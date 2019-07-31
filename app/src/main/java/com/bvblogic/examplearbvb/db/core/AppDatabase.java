package com.bvblogic.examplearbvb.db.core;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.bvblogic.examplearbvb.db.dao.ChatDao;
import com.bvblogic.examplearbvb.db.dao.MessageDao;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.Message;

/**
 * Created by hanz on 08.05.2018.
 */


@Database(entities = {Chat.class, Message.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "imc.db";

    private static AppDatabase INSTANCE;

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
