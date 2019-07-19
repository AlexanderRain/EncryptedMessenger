package com.bvblogic.examplearbvb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.bvblogic.examplearbvb.db.domain.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;


/**
 * Created by hanz on 08.05.2018.
 */

@Dao
public abstract class UserDao implements BaseDao<User> {

    @Query("SELECT * FROM user")
    public abstract Single<List<User>> getAll();

    @Query("SELECT * FROM user WHERE chat_id=:id")
    public abstract Single<User> getUserById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<User> users);

    @Delete
    public abstract void delete(User user);
}
