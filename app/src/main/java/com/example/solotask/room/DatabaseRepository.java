package com.example.solotask.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Database;

import com.example.solotask.network.entities.Result;

import java.util.List;

public class DatabaseRepository {
    private ResultDao resultDao;
    private LiveData<List<Result>> allResults;

    public DatabaseRepository(Application application){
        resultDao = ResultDatabase.getInstance(application).resultDao();
        allResults = resultDao.getAllItems();
    }

    public void insert(Result result){
        new InsertAsyncTask(resultDao).execute(result);
    }

    public void insertAll(List<Result> results){
        new InsertAllAsyncTask(resultDao).execute(results);
    }
    public void delete(Result result){
        new DeleteAsyncTask(resultDao).execute(result);
    }

    public void update(Result result){
        new UpdateAsyncTask(resultDao).execute(result);
    }

    public void deleteAll(){
        new DeleteAllAsyncTask(resultDao).execute();
    }

    public LiveData<List<Result>> getAllResults(){
        new GetAllAsyncTask(resultDao).execute();
        return allResults;
    }
    static class GetAllAsyncTask extends AsyncTask<Void,Void,Void>{
        private ResultDao resultDao;

        public GetAllAsyncTask(ResultDao resultDao) {
            this.resultDao = resultDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            resultDao.getAllItems();
            return null;
        }
    }

    static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void>{
        private ResultDao resultDao;

        public DeleteAllAsyncTask(ResultDao resultDao) {
            this.resultDao = resultDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            resultDao.deleteAll();
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<Result,Void,Void>{
        private ResultDao resultDao;

        public UpdateAsyncTask(ResultDao resultDao) {
            this.resultDao = resultDao;
        }

        @Override
        protected Void doInBackground(Result... results) {
            resultDao.update(results[0].isFavorite(),results[0].getId1());
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Result,Void,Void>{
        private ResultDao resultDao;


        public DeleteAsyncTask(ResultDao resultDao) {
            this.resultDao = resultDao;
        }

        @Override
        protected Void doInBackground(Result... results) {
            resultDao.delete(results[0]);
            return null;
        }
    }


    static class InsertAllAsyncTask extends AsyncTask<List<Result>,Void,Void>{
        private ResultDao resultDao;

        public InsertAllAsyncTask(ResultDao resultDao) {
            this.resultDao = resultDao;
        }

        @Override
        protected Void doInBackground(List<Result>... lists) {
            resultDao.insertAll(lists[0]);
            return null;
        }
    }

    static class InsertAsyncTask extends AsyncTask<Result,Void,Void>{
        private ResultDao resultDao;

        public InsertAsyncTask(ResultDao resultDao) {
            this.resultDao = resultDao;
        }

        @Override
        protected Void doInBackground(Result... results) {
             resultDao.insert(results[0]);
             return null;
        }
    }
}
