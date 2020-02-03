package com.example.solotask.network.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnetivityUtils {
    public static NetworkInfo getNetworkInfo(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }
    public static boolean isConnected(Context context){
        NetworkInfo info = ConnetivityUtils.getNetworkInfo(context);
        return (info != null && info.isConnected());
    }
}
