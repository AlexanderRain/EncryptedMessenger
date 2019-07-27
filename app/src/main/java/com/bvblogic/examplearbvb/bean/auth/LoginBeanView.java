package com.bvblogic.examplearbvb.bean.auth;

import android.view.View;
import android.widget.ProgressBar;
import android.util.Log;
import android.widget.Toast;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.api.core.BaseView;
import com.bvblogic.examplearbvb.api.model.Error;
import com.bvblogic.examplearbvb.api.model.User;
import com.bvblogic.examplearbvb.api.presenter.LoginPresenter;
import com.bvblogic.examplearbvb.bean.preference.PreferenceBean;
import com.bvblogic.examplearbvb.bean.preference.core.Preference;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

@EBean
public class LoginBeanView extends UserBean implements BaseView<User> {

    @Bean
    PreferenceBean preferenceBean;

    @Override
    public void init() {
        super.init();
        getUserDeps().inject(this);
    }

    @Override
    public void onFailure(Error error) {
        Toast.makeText(activity, "Invalid username or password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(User user) {
        if(preferenceBean.getUsername() != null){
            Log.e("USER IN PREFS", preferenceBean.getUsername());
            preferenceBean.removeUsername();
        }
        preferenceBean.saveUsername(user.getUsername());
        Log.e("In PREFS", preferenceBean.getUsername());
        Toast.makeText(activity, preferenceBean.getUsername(), Toast.LENGTH_SHORT).show();
        activity.changeFragmentTo(new FragmentData(FragmentById.CHATS_FRAGMENT));
    }

    public void login(String username, String password){
        new LoginPresenter(userNetworking, this).login(username, password);
    }



    @ViewById(R.id.progress)
    ProgressBar progressBar;

    @Override
    public void showWait() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideWait() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}
