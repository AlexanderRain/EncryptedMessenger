package com.bvblogic.examplearbvb.db.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Single;

public interface BaseDao<T> {

    Single<List<T>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<T> data);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(T data);

    @Update
    void update(T... data);

    @Delete
    void delete(T data);
}
