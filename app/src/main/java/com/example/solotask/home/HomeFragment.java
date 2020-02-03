package com.example.solotask.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.solotask.R;
import com.example.solotask.adapters.ResultAdapter;
import com.example.solotask.network.entities.Result;
import com.example.solotask.network.retrofit.MainViewModel;
import com.example.solotask.network.utils.ConnetivityUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ResultAdapter.OnFavoriteListener {
    private ResultAdapter resultAdapter;
    private MainViewModel mainViewModel;
    private RecyclerView rvHome;


    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvHome = view.findViewById(R.id.rv_home);
        rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        resultAdapter = new ResultAdapter(getActivity(),this);

            if (ConnetivityUtils.isConnected(getActivity())) {
                mainViewModel.search();
                MutableLiveData<List<Result>> listMutableLiveData = mainViewModel.getResults();
                listMutableLiveData.observe(getActivity(), new Observer<List<Result>>() {
                    @Override
                    public void onChanged(List<Result> results) {
                        List<Result> cachedList = mainViewModel.getAllResultsFromDb().getValue();
                        if (cachedList != null && results.containsAll(cachedList) && cachedList.containsAll(results))
                            return;

                        mainViewModel.insertAll(results);
                    }
                });
            }
        mainViewModel.getAllResultsFromDb().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                resultAdapter.setResultList(results);
            }
        });
        rvHome.setAdapter(resultAdapter);
        return view;
    }

    @Override
    public void onFavoriteInserted(Result resultItem) {
        resultItem.setFavorite(true);
        mainViewModel.update(resultItem);
    }

    @Override
    public void onFavoriteDeleted(Result resultItem) {
        resultItem.setFavorite(false);
        mainViewModel.update(resultItem);


    }
}
