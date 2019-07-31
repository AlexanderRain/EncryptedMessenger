package com.bvblogic.examplearbvb.bean.user;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bvblogic.examplearbvb.adapter.chats.ChatsAdapter;
import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.db.domain.Chat;

import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class   ProviderBeanChat extends Bean {

    @org.androidannotations.annotations.Bean
    ChatsAdapter adapter;

    public void initAdapter(RecyclerView rv) {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(activity));
        rv.setAdapter(adapter);
    }

    public void setItems(List<Chat> chats) {
        adapter.setItems(chats);
    }

}
