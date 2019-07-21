package com.bvblogic.examplearbvb.bean.instruments;

import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.presenter.ChatsPresenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class InstrumentsPresenter {
    @Bean
    ChatsPresenter chatsPresenter;

    public void saveUser(Instrument instrument, String username, String chatName) {
        chatsPresenter.addChat(new Chat(chatName, instrument.getName(), username));
    }
}
