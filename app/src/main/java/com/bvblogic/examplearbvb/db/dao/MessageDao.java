package com.bvblogic.examplearbvb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.bvblogic.examplearbvb.db.domain.Message;

import java.util.List;

import io.reactivex.Single;

@Dao
public abstract class MessageDao implements BaseDao<Message> {
    @Query("SELECT * FROM message")
    public abstract Single<List<Message>> getAll();

    @Query("SELECT * FROM message WHERE chat_id=:id")
    public abstract Single<List<Message>> getMessagesById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<Message> messages);
}
