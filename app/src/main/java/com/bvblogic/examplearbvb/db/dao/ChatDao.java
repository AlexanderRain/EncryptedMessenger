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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<Chat> chats);

}
