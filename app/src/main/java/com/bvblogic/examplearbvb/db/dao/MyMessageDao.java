package com.bvblogic.examplearbvb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.bvblogic.examplearbvb.db.domain.MyMessage;
import com.bvblogic.examplearbvb.db.domain.User;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface MyMessageDao {

    @Query("SELECT * FROM messages")
    Single<List<MyMessage>> getAll();

    @Query("SELECT COUNT(*) from messages")
    int countMessages();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(MyMessage... messages);

    @Delete
    void delete(MyMessage message);
}

