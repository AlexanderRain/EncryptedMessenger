package com.bvblogic.examplearbvb.api.presenter;

import android.util.Log;

import com.bvblogic.examplearbvb.api.core.BaseView;
import com.bvblogic.examplearbvb.api.model.User;
import com.bvblogic.examplearbvb.api.networking.UserNetworking;
import com.bvblogic.examplearbvb.api.networking.core.Service;
import com.bvblogic.examplearbvb.api.networking.error.NetworkError;
import com.bvblogic.examplearbvb.api.presenter.core.Presenter;
import com.bvblogic.examplearbvb.bean.auth.RegisterBeanView;

import okhttp3.ResponseBody;


public class RegisterPresenter extends Presenter<UserNetworking, ResponseBody> {


    public RegisterPresenter(UserNetworking service, BaseView<ResponseBody> responseBodyBaseView) {
        super(service, responseBodyBaseView);
    }

    public void register(User user){
        yBaseView.showWait();
        compositeDisposable.add(service.registerUser(user, new Service.Callback<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody responseBody) {
                yBaseView.hideWait();
                yBaseView.onSuccess(responseBody);
                ((RegisterBeanView) yBaseView).saveUsernameToPrefs(user.getUsername());
                // TODO: add username to shared prefs
                stop();
            }

            @Override
            public void onError(NetworkError networkError) {
                yBaseView.hideWait();
                yBaseView.onFailure(networkError.getAppErrorMessage());
                Log.e("ERROR", networkError.getMessage());
                stop();
            }
        }));
    }
}
