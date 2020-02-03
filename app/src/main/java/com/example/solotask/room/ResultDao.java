package com.example.solotask.room;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.solotask.network.entities.Result;

import java.util.List;

@androidx.room.Dao
public interface ResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result result);
    @Delete
    void delete(Result result);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Result> results);

    @Query("UPDATE resultItems SET isFavorite=:isFavorite  WHERE id1 = :id1")
    void update(boolean isFavorite, int id1);


    @Query("DELETE FROM resultItems")
    void deleteAll();

    @Query("SELECT * FROM resultItems")
    LiveData<List<Result>> getAllItems();
}
