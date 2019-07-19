package com.bvblogic.examplearbvb.db.presenter;

import android.support.v7.widget.RecyclerView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.user.ProviderBeanMessage;
import com.bvblogic.examplearbvb.db.datamanager.MessageDataManager;
import com.bvblogic.examplearbvb.db.domain.Message;
import com.bvblogic.examplearbvb.db.presenter.core.Presenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EBean
public class MessagePresenter extends Presenter<List<Message>> {

    @ViewById(R.id.message_recycler)
    RecyclerView messagesRecycler;

    @Bean
    ProviderBeanMessage providerBeanMessage;

    public void getMessages(int chatId) {
        new MessageDataManager().getManages(appDatabase, this, chatId);
    }

    @Override
    public void onSuccess(List<Message> messages) {
        providerBeanMessage.initAdapter(messagesRecycler);
        providerBeanMessage.setItems(messages);
    }
}
