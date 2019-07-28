package com.bvblogic.examplearbvb.bean.io;

import android.os.AsyncTask;
import android.util.Log;

import com.bvblogic.examplearbvb.bean.coding.CodingPresenter;
import com.bvblogic.examplearbvb.bean.io.core.Keys;
import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.datamanager.ChatDataManager;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.Message;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class KeysTask extends AsyncTask<Message, Keys, Keys> {

    @Bean
    CodingPresenter codingPresenter;

    @Bean
    SecondaryKeyParser secondaryKeyParser;

    private AppDatabase appDatabase;

    public void setAppDatabase(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }



    @Override
    protected Keys doInBackground(Message... messages) {
        Chat chat = new ChatDataManager().getByMessage(appDatabase, messages[0].getChatId());
        Keys keys = secondaryKeyParser.getByChat(chat);
        codingPresenter.setKeys(keys);
        codingPresenter.send(messages[0]);
        return keys;
    }
}
