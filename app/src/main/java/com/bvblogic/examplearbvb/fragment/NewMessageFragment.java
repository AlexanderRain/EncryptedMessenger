package com.bvblogic.examplearbvb.fragment;

import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.newMessage.NewMessageView;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_new_message)
public class NewMessageFragment extends BaseFragment {

    // This arg is injected when this fragment is created. It will be set in TextView
    @FragmentArg("username")
    public String username;

    // TextView for username
    @ViewById
    TextView tvUsername;

    @Bean
    public NewMessageView view;

    @AfterViews
    public void init(){
        tvUsername.setText(username);
    }
}