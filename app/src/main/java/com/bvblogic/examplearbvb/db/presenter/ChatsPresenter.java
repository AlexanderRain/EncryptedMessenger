package com.bvblogic.examplearbvb.db.presenter;

import android.support.v7.widget.RecyclerView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.user.ProviderBeanChat;
import com.bvblogic.examplearbvb.db.datamanager.ChatDataManager;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.presenter.core.Presenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by hanz on 08.05.2018.
 */

@EBean
public class ChatsPresenter extends Presenter<List<Chat>> {

    @ViewById(R.id.chat_recycler)
    RecyclerView recyclerView;

    @Bean
    ProviderBeanChat providerBeanChat;

    public void getAllChats() {
        new ChatDataManager().getAllChats(appDatabase, this);
    }

    public void addChat(Chat chat) {
        new ChatDataManager().addChat(appDatabase, chat);
    }

    public void updateChat(Chat chat) {
        new ChatDataManager().updateChat(appDatabase, chat);
    }

    @Override
    public void onSuccess(List<Chat> chats) {
        providerBeanChat.initAdapter(recyclerView);
        providerBeanChat.setItems(chats);
    }
}
