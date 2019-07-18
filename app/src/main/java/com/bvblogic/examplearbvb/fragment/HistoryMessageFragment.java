package com.bvblogic.examplearbvb.fragment;

import android.support.v7.widget.RecyclerView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.domain.MyMessage;
import com.bvblogic.examplearbvb.db.presenter.MyMessagePresenter;
import com.bvblogic.examplearbvb.db.presenter.UserPresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Random;

@EFragment(R.layout.fragment_message_history)
public class HistoryMessageFragment extends BaseFragment {

    @ViewById
    RecyclerView recycler;

    @Bean
    MyMessagePresenter messagePresenter;

    @AfterViews
    public void init() {


        BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.BLUE);
        initToolBar(ToolBarById.CLOSE);
        MyMessage myMessage = new MyMessage();
        myMessage.setMessId(new Random().nextInt());
        myMessage.setMessage("let's smoke bamboo ;D");
        myMessage.setDate("2019.02.02 4:20");
        myMessage.setReceived(true);
        messagePresenter.saveMessage(myMessage);
        messagePresenter.getAllMessages();

    }

}
