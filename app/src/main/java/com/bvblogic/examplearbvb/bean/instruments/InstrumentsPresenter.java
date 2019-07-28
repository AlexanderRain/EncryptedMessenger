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
        String address = instrument.getAddress();
        Chat chat = new Chat();
        chat.setAddress(address);
        chat.setRecipient(username);
        chat.setChatName(chatName);
        chat.setType(instrument.getAction());
        chatsPresenter.addChat(chat);
    }
}
