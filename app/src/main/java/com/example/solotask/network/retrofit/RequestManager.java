package com.example.solotask.network.retrofit;

import com.example.solotask.network.entities.BaseResponse;
import com.example.solotask.network.retrofit.utils.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestManager {
    public static final String API_KEY = "d0c139d5-979f-4e8d-b40c-90a04de31979";
    public static void search(final OnSearchListener onSearchListener){
        Call<BaseResponse> call = RetrofitClient.getInstance().getRequestApiService().search(API_KEY);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                LogUtils.d(this.getClass().getSimpleName() + "message: " + response.message());
                if (response.body() != null){
                    onSearchListener.onSearchSuccess(response.body());
                    LogUtils.d("code: " + response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                LogUtils.d(t.toString());
                LogUtils.d("onFailure: call" + call.toString());
                LogUtils.d("onFailure: throwable" + t.toString());

            }
        });
    }






    public interface OnSearchListener{
        void onSearchSuccess(BaseResponse baseResponse);
        void onSearchFail(String message);
    }
}
