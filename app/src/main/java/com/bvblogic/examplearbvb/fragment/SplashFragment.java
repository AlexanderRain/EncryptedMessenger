package com.bvblogic.examplearbvb.fragment;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.presenter.ChatsPresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;

import java.util.Random;

@EFragment(R.layout.fragment_splash)
public class SplashFragment extends BaseFragment {

    @Bean
    ChatsPresenter chatsPresenter;

    @AfterViews
    public void init() {
        BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.BLUE);
        initToolBar(ToolBarById.CLOSE);
        Chat chat = new Chat();
        chat.setId(new Random().nextInt());
        chat.setChatName("simple chat");
        chatsPresenter.saveChats(chat);
        chatsPresenter.getAllChats();
    }

}
