package com.bvblogic.examplearbvb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.bvblogic.examplearbvb.db.domain.Chat;

import java.util.List;

import io.reactivex.Single;

@Dao
public abstract class ChatDao implements BaseDao<Chat> {

    @Query("SELECT * FROM chat")
    public abstract Single<List<Chat>> getAll();

    @Query("SELECT * FROM chat WHERE id=:id")
    public abstract Single<Chat> getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<Chat> chats);

}
