package com.bvblogic.examplearbvb.db.presenter;

import com.bvblogic.examplearbvb.db.domain.User;
import com.bvblogic.examplearbvb.db.presenter.core.Presenter;

import org.androidannotations.annotations.EBean;

@EBean
public class AuthPresenter extends Presenter<User> {

    @Override
    public void onSuccess(User user) {

    }
}
