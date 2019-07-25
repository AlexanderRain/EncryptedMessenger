package com.bvblogic.examplearbvb.db.presenter;


import com.bvblogic.examplearbvb.bean.user.ProviderBeanUserChat;
import com.bvblogic.examplearbvb.db.datamanager.ChatDataManager;
import com.bvblogic.examplearbvb.db.datamanager.core.DataManager;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.presenter.core.Presenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hanz on 08.05.2018.
 */

@EBean
public class UserChatPresenter extends Presenter<Chat> {

    @Bean
    ProviderBeanUserChat view;

    public void getChat(int id) {
        new ChatDataManager().getById(id, appDatabase, this);
    }

    @Override
    public void onSuccess(Chat chat) {
        view.setUserName(chat.getRecipient());
        view.setChatType(chat.getType().getActionName());
        view.initSendBean(chat);
    }
}
