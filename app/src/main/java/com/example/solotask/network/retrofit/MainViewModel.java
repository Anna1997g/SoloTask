package com.example.solotask.network.retrofit;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.solotask.network.entities.Result;
import com.example.solotask.room.DatabaseRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private RetrofitRepository retrofitRepository;
    private MutableLiveData<List<Result>> results;

    private DatabaseRepository databaseRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        retrofitRepository = new RetrofitRepository();
        results = retrofitRepository.getAllresults();
        databaseRepository = new DatabaseRepository(application);
    }

    public MutableLiveData<List<Result>> getResults() {
        return results;
    }

    public void search(){
        retrofitRepository.search();
    }

    public void insert(Result result){
        databaseRepository.insert(result);
    }

    public void insertAll(List<Result> results){
        databaseRepository.insertAll(results);
    }

    public void update(Result result){
        databaseRepository.update(result);
    }

    public void delete(Result result){
        databaseRepository.delete(result);
    }
    public void deleteAll(){
        databaseRepository.deleteAll();
    }
    public LiveData<List<Result>> getAllResultsFromDb(){
      return   databaseRepository.getAllResults();
    }


}
