package com.bvblogic.examplearbvb.db.presenter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.datamanager.ChatDataManager;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.presenter.core.Presenter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by hanz on 08.05.2018.
 */

@EBean
public class ChatsPresenter extends Presenter<List<Chat>> {
    @ViewById(R.id.rv)
    RecyclerView recyclerView;

    public void getAllChats() {
        new ChatDataManager().getAllChats(appDatabase, this);
    }

    public void saveChats(Chat chat) {
        new ChatDataManager().saveChats(chat, appDatabase);
    }


    @Override
    public void onSuccess(List<Chat> chats) {
        Log.i("ChatsPresenter", "Chats amount " + chats.size());
        //providerBeanUser.initAdapter(recyclerView);
        //providerBeanUser.initAdapter(chats);
    }
}
