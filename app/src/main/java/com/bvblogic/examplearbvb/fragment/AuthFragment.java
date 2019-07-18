package com.bvblogic.examplearbvb.fragment;

import android.widget.EditText;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.Message;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Random;

@EFragment(R.layout.fragment_auth)
public class AuthFragment extends BaseFragment {

    @ViewById
    EditText etLogin;

    @ViewById
    EditText etPassword;

    @Click(R.id.btnLogin)
    void loginUser(){
        String login = etLogin.getText().toString();
        String pass = etPassword.getText().toString();
    }

    @Click(R.id.btnSignUp)
    void singUp(){
        // TODO CreateUserFragment or whatever opens
    }

    @AfterViews
    public void init() {
        initToolBar(ToolBarById.CLOSE);
        BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.BLUE);
        initToolBar(ToolBarById.CLOSE);

        //testing data
        Message message = new Message();
        message.setId(new Random().nextInt());
        message.setText("let's smoke bamboo ;D");
        message.setTime("11:50");

        Chat chat = new Chat();
        chat.setId(1);
        chat.setChatName("lalala");
    }
}
