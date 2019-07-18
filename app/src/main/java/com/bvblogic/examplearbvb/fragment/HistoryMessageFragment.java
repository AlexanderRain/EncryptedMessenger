package com.bvblogic.examplearbvb.fragment;

import android.support.v7.widget.RecyclerView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.domain.Message;
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

    @AfterViews
    public void init() {

    }

}
