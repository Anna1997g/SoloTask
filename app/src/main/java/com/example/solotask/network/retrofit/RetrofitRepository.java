package com.example.solotask.network.retrofit;

import androidx.lifecycle.MutableLiveData;

import com.example.solotask.network.entities.BaseResponse;
import com.example.solotask.network.entities.Result;

import java.util.List;

public class RetrofitRepository implements RequestManager.OnSearchListener {
    MutableLiveData<List<Result>> allresults;

    public RetrofitRepository() {
        allresults = new MutableLiveData<>();
    }

    public MutableLiveData<List<Result>> getAllresults() {
        return allresults;
    }
    public void search(){
        RequestManager.search(this);
    }

    @Override
    public void onSearchSuccess(BaseResponse baseResponse) {
        allresults.setValue(baseResponse.getResponse().getResults());
    }

    @Override
    public void onSearchFail(String message) {

    }
}
