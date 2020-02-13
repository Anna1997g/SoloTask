package com.example.solotask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.solotask.adapters.ViewPagerAdapter;
import com.example.solotask.favorite.FavoriteFragment;
import com.example.solotask.home.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import me.pushy.sdk.Pushy;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), initFragmentsForViewPager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Home Page");
        tabLayout.getTabAt(1).setText("Favorite Page");

        pushyInitialize();

    }


    private List<Fragment> initFragmentsForViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FavoriteFragment());
        return fragments;
    }

    private void pushyPermissionCheck() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }

    }

    private void pushyInitialize() {
        if (!Pushy.isRegistered(getApplicationContext())) {
            pushyPermissionCheck();
            new RegisterForPushNotificationsAsync().execute();
            new SubscribeForTopicAsync().execute();
        } else {
            Pushy.listen(this);
        }

    }


    private class RegisterForPushNotificationsAsync extends AsyncTask<Void, Void, Exception> {

        @Override
        protected Exception doInBackground(Void... voids) {
            try {
                String deviceToken = Pushy.register(getApplicationContext());
            } catch (Exception exc) {
                return exc;
            }
            return null;
        }


        @Override
        protected void onPostExecute(Exception e) {
            super.onPostExecute(e);
            if (e != null) {
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                Pushy.listen(MainActivity.this);
                return;
            }
        }
    }

    private class SubscribeForTopicAsync extends AsyncTask<Void,Void,Exception>{

        @Override
        protected Exception doInBackground(Void... voids) {
            try {
                Pushy.subscribe("news",getApplicationContext());
            }catch (Exception e){
                return e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Exception e) {
            super.onPostExecute(e);
            if (e != null){
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
}
