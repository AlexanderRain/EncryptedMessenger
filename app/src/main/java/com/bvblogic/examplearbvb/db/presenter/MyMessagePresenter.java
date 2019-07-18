package com.bvblogic.examplearbvb.db.presenter;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.user.ProviderBeanMyMessage;
import com.bvblogic.examplearbvb.bean.user.ProviderBeanUser;
import com.bvblogic.examplearbvb.db.datamanager.MyMessageDataManager;
import com.bvblogic.examplearbvb.db.datamanager.UserDataManager;
import com.bvblogic.examplearbvb.db.domain.MyMessage;
import com.bvblogic.examplearbvb.db.presenter.core.Presenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EBean
public class MyMessagePresenter extends Presenter<List<MyMessage>> {
    @ViewById(R.id.recycler)
    RecyclerView recyclerView;

    @Bean
    ProviderBeanMyMessage providerBeanMyMessage;


    public void getAllMessages() {
        new MyMessageDataManager().getAllMessages(appDatabase, this);
    }

    public void saveMessage(MyMessage message) {
        new MyMessageDataManager().saveMessage(message, appDatabase, new Presenter<Long>() {
            @Override
            public void onSuccess(Long aLong) {
                Toast.makeText(activity, "" + aLong, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSuccess(List<MyMessage> myMessages) {
        if (myMessages != null)
            Toast.makeText(activity, "" + myMessages.size(), Toast.LENGTH_LONG).show();
        providerBeanMyMessage.initAdapter(recyclerView);
        providerBeanMyMessage.initAdapter(myMessages);
    }
}