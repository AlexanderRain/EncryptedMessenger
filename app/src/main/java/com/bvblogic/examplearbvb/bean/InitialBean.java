package com.bvblogic.examplearbvb.bean;

import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.datamanager.core.DataManager;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.Message;

import org.androidannotations.annotations.EBean;

import java.util.List;

/**
 * Created for insert test data in database
 * */
@EBean
public class InitialBean extends Bean {

    public void saveMessage(List<Message> message) {
        new DataManager().saveData(message, AppDatabase.getAppDatabase(activity).messageDao());

    }

    public void saveChat(List<Chat> chat) {
        new DataManager().saveData(chat, AppDatabase.getAppDatabase(activity).chatDao());
    }
}
