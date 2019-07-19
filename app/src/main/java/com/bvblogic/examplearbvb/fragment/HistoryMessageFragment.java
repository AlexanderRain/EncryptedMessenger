package com.bvblogic.examplearbvb.fragment;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.presenter.MessagePresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;

@EFragment(R.layout.fragment_message_history)
public class HistoryMessageFragment extends BaseFragment {

    @FragmentArg("chatId")
    public int chatId;

    @Bean
    MessagePresenter messagePresenter;

    @AfterViews
    public void init() {
        messagePresenter.getMessages(chatId);
    }

}
