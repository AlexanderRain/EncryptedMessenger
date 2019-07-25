package com.bvblogic.examplearbvb.api.presenter;

import com.bvblogic.examplearbvb.api.core.BaseView;
import com.bvblogic.examplearbvb.api.model.Token;
import com.bvblogic.examplearbvb.api.model.User;
import com.bvblogic.examplearbvb.api.networking.LoginNetworking;
import com.bvblogic.examplearbvb.api.networking.UserNetworking;
import com.bvblogic.examplearbvb.api.networking.core.Service;
import com.bvblogic.examplearbvb.api.networking.error.NetworkError;
import com.bvblogic.examplearbvb.api.presenter.core.Presenter;
import com.bvblogic.examplearbvb.bean.auth.LoginBeanView;
import com.bvblogic.examplearbvb.bean.auth.RegisterBeanView;

public class LoginPresenter extends Presenter<UserNetworking, User> {
    public LoginPresenter(UserNetworking service, BaseView<User> baseView) {
        super(service, baseView);
    }

    public void login(String username, String password) {
        yBaseView.showWait();
        compositeDisposable.add(service.login(username, password, new Service.Callback<User>() {
            @Override
            public void onSuccess(User user) {
                yBaseView.hideWait();
                yBaseView.onSuccess(user);
                stop();
            }

            @Override
            public void onError(NetworkError networkError) {
                yBaseView.hideWait();
                yBaseView.onFailure(networkError.getAppErrorMessage());
                stop();
            }
        }));

    }
}
