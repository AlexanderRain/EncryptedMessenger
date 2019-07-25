package com.bvblogic.examplearbvb.api.deps;

import com.bvblogic.examplearbvb.api.networking.module.NetworkModule;
import com.bvblogic.examplearbvb.api.presenter.RegisterPresenter;
import com.bvblogic.examplearbvb.bean.register.RegisterBean;
import com.bvblogic.examplearbvb.bean.register.RegisterBeanView;
import com.bvblogic.examplearbvb.fragment.RegistrationFragment;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = NetworkModule.class)
@Singleton
public interface UserDeps {
    void inject(RegisterBeanView view);
}
