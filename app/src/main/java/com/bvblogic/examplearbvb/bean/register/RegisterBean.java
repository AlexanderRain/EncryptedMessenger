package com.bvblogic.examplearbvb.bean.register;

import com.bvblogic.examplearbvb.api.deps.DaggerUserDeps;
import com.bvblogic.examplearbvb.api.deps.UserDeps;
import com.bvblogic.examplearbvb.api.networking.UserNetworking;
import com.bvblogic.examplearbvb.api.networking.module.NetworkModule;
import com.bvblogic.examplearbvb.bean.core.BeanAPI;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import javax.inject.Inject;

import okhttp3.ResponseBody;

@EBean
public abstract class RegisterBean extends BeanAPI<ResponseBody> {

    private UserDeps userDeps;

    public UserDeps getUserDeps() {
        return userDeps;
    }

    @Inject
    public UserNetworking userNetworking;

    @AfterInject
    public void init(){
        userDeps = DaggerUserDeps.builder().networkModule
                (new NetworkModule("https://evening-ocean-71194.herokuapp.com/ ", activity)).build();
    }
}
