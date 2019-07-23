package com.bvblogic.examplearbvb.api.networking;

import android.util.Log;

import com.bvblogic.examplearbvb.api.model.Token;
import com.bvblogic.examplearbvb.api.networking.core.Service;
import com.bvblogic.examplearbvb.api.networking.error.NetworkError;
import com.bvblogic.examplearbvb.api.service.LoginService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginNetworking extends Service<LoginService> {
    public LoginNetworking(LoginService networkService) {
        super(networkService);
    }

    public Disposable login(String username, String password, String email, String phone, String role, final Callback<Token> userCallback) {
        return networkService.login(username, password, email, phone, role)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Token>() {

                    @Override
                    public void onNext(Token token) {
                        Log.e("asf", token.getMyToken());
                    }

                    @Override
                    public void onError(Throwable e) {
                        userCallback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
