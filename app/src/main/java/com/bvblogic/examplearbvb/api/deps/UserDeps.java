package com.bvblogic.examplearbvb.api.deps;

import com.bvblogic.examplearbvb.api.networking.module.NetworkModule;
import com.bvblogic.examplearbvb.bean.auth.LoginBeanView;
import com.bvblogic.examplearbvb.bean.auth.RegisterBeanView;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = NetworkModule.class)
@Singleton
public interface UserDeps {
    void inject(RegisterBeanView view);
    void inject(LoginBeanView view);

}
