package com.bvblogic.examplearbvb.api.presenter;

import com.bvblogic.examplearbvb.api.core.BaseView;
import com.bvblogic.examplearbvb.api.model.Token;
import com.bvblogic.examplearbvb.api.networking.LoginNetworking;
import com.bvblogic.examplearbvb.api.networking.core.Service;
import com.bvblogic.examplearbvb.api.networking.error.NetworkError;
import com.bvblogic.examplearbvb.api.presenter.core.Presenter;

public class LoginPresenter extends Presenter<LoginNetworking, Token> {
    public LoginPresenter(LoginNetworking service, BaseView<Token> tokenBaseView) {
        super(service, tokenBaseView);
    }

    public void login(String username, String password, String email, String phone, String role) {
        yBaseView.showWait();
        compositeDisposable.add(service.login(username, password, email, phone, role, new Service.Callback<Token>() {
            @Override
            public void onSuccess(Token token) {
                yBaseView.hideWait();
                yBaseView.onSuccess(token);
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
