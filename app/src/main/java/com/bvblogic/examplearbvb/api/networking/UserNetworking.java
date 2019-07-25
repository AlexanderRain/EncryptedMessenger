package com.bvblogic.examplearbvb.api.networking;

import android.util.Log;
import android.widget.Toast;

import com.bvblogic.examplearbvb.api.model.User;
import com.bvblogic.examplearbvb.api.networking.core.Service;
import com.bvblogic.examplearbvb.api.networking.error.NetworkError;
import com.bvblogic.examplearbvb.api.service.UserService;
import com.bvblogic.examplearbvb.utils.AuthHelper;

import java.io.IOException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class UserNetworking extends Service<UserService> {
    public UserNetworking(UserService userService) {
        super(userService);
    }

    public Disposable registerUser(User user, final Callback<ResponseBody> callback){
        return networkService.register(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        // TODO: insert into file
                        Log.e("HELLO", "newworking");
                        callback.onSuccess(responseBody);
                    }
                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }
                    @Override
                    public void onComplete() {}
                });

    }

    public Disposable login(String username, String password, final Callback<User> callback){
        String authToken = AuthHelper.getAuthToken(username, password);
        return networkService.login(authToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<User>() {
                    @Override
                    public void onNext(User user) {
                        callback.onSuccess(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
