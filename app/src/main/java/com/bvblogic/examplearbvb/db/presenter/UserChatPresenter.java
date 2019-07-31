package com.bvblogic.examplearbvb.db.presenter;


import com.bvblogic.examplearbvb.bean.io.KeysTask;
import com.bvblogic.examplearbvb.db.datamanager.ChatDataManager;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.Message;
import com.bvblogic.examplearbvb.db.presenter.core.Presenter;
import com.bvblogic.examplearbvb.fragment.NewMessageFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by hanz on 08.05.2018.
 */

@EBean
public class UserChatPresenter extends Presenter<Chat> {


    private NewMessageFragment fragment;

    public void setFragment(NewMessageFragment fragment) {
        this.fragment = fragment;
    }

    @Bean
    KeysTask keysTask;

    public void getChat(int id) {
        new ChatDataManager().getById(id, appDatabase, this);
    }

    @Override
    public void onSuccess(Chat chat) {
        fragment.setUserName(chat.getRecipient());
        fragment.setChatType(chat.getType().getActionName());
//        view.initSendBean(chat);
    }

    public void sendMessage(Message message){
        keysTask.setAppDatabase(appDatabase);
        keysTask.execute(message);
    }
}
