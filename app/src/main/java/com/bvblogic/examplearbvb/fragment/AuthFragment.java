package com.bvblogic.examplearbvb.fragment;

import android.util.Log;
import android.widget.EditText;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

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
        if(pass != "" && login != ""){
            // todo enter to system
            // changeFragmentTo(new FragmentData(FragmentById.NEXT_FRAGMENT));
        }

        //changeFragmentTo(new FragmentData(FragmentById.SPLASH_FRAGMENT));
        Log.d("Data", login + " " + pass);
    }

    @Click(R.id.btnSignUp)
    void singUp(){
        // TODO CreateUserFragment or whatever opens
    }

    @AfterViews
    public void init() {
       // BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.BLUE);
       // initToolBar(ToolBarById.CLOSE);
    }
}
