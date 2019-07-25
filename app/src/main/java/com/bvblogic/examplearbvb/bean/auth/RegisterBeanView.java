package com.bvblogic.examplearbvb.bean.auth;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.api.core.BaseView;
import com.bvblogic.examplearbvb.api.model.Error;
import com.bvblogic.examplearbvb.api.model.User;
import com.bvblogic.examplearbvb.api.presenter.RegisterPresenter;
import com.bvblogic.examplearbvb.bean.preference.PreferenceBean;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

import okhttp3.ResponseBody;

@EBean
public class RegisterBeanView extends UserBean implements BaseView<ResponseBody> {

    private Context context;

    @Bean
    PreferenceBean preferenceBean;

    @ViewById(R.id.user_name)
    MaterialEditText userName;

    @ViewById(R.id.password)
    MaterialEditText password;

    @ViewById(R.id.email)
    MaterialEditText email;

    @ViewById(R.id.phone)
    MaterialEditText phone;

    public RegisterBeanView(Context context) {
        this.context = context;
    }

    @Override
    public void init() {
        super.init();
        getUserDeps().inject(this);
    }


    @Click(R.id.sign_up)
    public void validate() {
        if(areFielsValid()) {
            User user = new User(
                    userName.getText().toString(),
                    password.getText().toString(),
                    email.getText().toString(),
                    phone.getText().toString(),
                    "USER"
            );
            this.register(user);
        } else {
            Toast.makeText(context, "Fill all fields please!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean areFielsValid(){
        return userName.getText() !=null && userName.getText().length() >= 5 &&
                password.getText() != null && password.getText().length() >= 6 &&
                email.getText() != null && phone.getText() != null;

    }
    public void clearAllFields(){
        userName.setText("");
        password.setText("");
        email.setText("");
        phone.setText("");
    }


    public void register(User user){
        Log.e("HELLO", "beanview");
        new RegisterPresenter(userNetworking, this).register(user);
    }


    @Override
    public void onFailure(Error error) {
        Log.e("ER_CONTEXT", context.toString());
        Toast.makeText(context, "Such user exists!", Toast.LENGTH_SHORT).show();
        clearAllFields();
    }

    @Override
    public void onSuccess(ResponseBody responseBody) {
        activity.changeFragmentTo(new FragmentData(FragmentById.CHATS_FRAGMENT));
    }


    public void saveUsernameToPrefs(String username){
        preferenceBean.saveUsername(username);
    }
    @Override
    public void showWait() { }

    @Override
    public void hideWait() { }
}
