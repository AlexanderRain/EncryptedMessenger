package com.bvblogic.examplearbvb.fragment;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.presenter.ChatsPresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_chats)
public class ChatsFragment extends BaseFragment {

    @Bean
    ChatsPresenter chatsPresenter;

    @Click(R.id.add_chat)
    void openAdditionFragment() {
        changeFragmentTo(new FragmentData(FragmentById.CHAT_ADDITION));
    }

    @AfterViews
    public void init() {
        chatsPresenter.getAllChats();
    }
}
