package com.bvblogic.examplearbvb.bean.user;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bvblogic.examplearbvb.adapter.activities.HistoryMessageAdapter;
import com.bvblogic.examplearbvb.adapter.activities.UserAdapter;
import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.db.domain.MyMessage;
import com.bvblogic.examplearbvb.db.domain.User;

import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class ProviderBeanMyMessage extends Bean {

    @org.androidannotations.annotations.Bean
    public HistoryMessageAdapter adapter;


    public void initAdapter(RecyclerView rv) {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(activity));
        rv.setAdapter(adapter);
    }

    public void initAdapter(List<MyMessage> users) {
        adapter.setItems(users);

    }

}
