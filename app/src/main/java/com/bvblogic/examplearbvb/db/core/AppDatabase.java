package com.bvblogic.examplearbvb.db.core;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import com.bvblogic.examplearbvb.db.dao.MyMessageDao;
import com.bvblogic.examplearbvb.db.domain.MyMessage;
import com.bvblogic.examplearbvb.db.dao.ChatDao;
import com.bvblogic.examplearbvb.db.dao.MessageDao;
import com.bvblogic.examplearbvb.db.dao.UserDao;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.Message;
import com.bvblogic.examplearbvb.db.domain.User;

/**
 * Created by hanz on 08.05.2018.
 */


@Database(entities = {User.class, Chat.class, Message.class, MyMessage.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "imc.db";

    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();


    public abstract MyMessageDao myMessageDao();
    public abstract ChatDao chatDao();
    public abstract MessageDao messageDao();


    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }


    public static void destroyInstance() {
        INSTANCE = null;
    }
}
