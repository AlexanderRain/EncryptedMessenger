package com.bvblogic.examplearbvb.bean.auth;

import com.bvblogic.examplearbvb.api.deps.DaggerUserDeps;
import com.bvblogic.examplearbvb.api.deps.UserDeps;
import com.bvblogic.examplearbvb.api.networking.UserNetworking;
import com.bvblogic.examplearbvb.api.networking.module.NetworkModule;
import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.bean.preference.PreferenceBean;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import javax.inject.Inject;

@EBean
public abstract class UserBean extends Bean {

    @org.androidannotations.annotations.Bean
    protected PreferenceBean preferenceBean;

    private UserDeps userDeps;

    public UserDeps getUserDeps() {
        return userDeps;
    }

    @Inject
    public UserNetworking userNetworking;

    @AfterInject
    public void init(){
        userDeps = DaggerUserDeps.builder().networkModule
                (new NetworkModule("https://sleepy-river-11136.herokuapp.com/", activity)).build();

    }
}
