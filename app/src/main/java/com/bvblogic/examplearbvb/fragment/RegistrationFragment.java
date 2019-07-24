package com.bvblogic.examplearbvb.fragment;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.login.LoginBeanView;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_registration)
public class RegistrationFragment extends BaseFragment {

    @Bean
    LoginBeanView loginBeanView;

    @ViewById(R.id.user_name)
    MaterialEditText userName;

    @ViewById(R.id.password)
    MaterialEditText password;

    @ViewById(R.id.email)
    MaterialEditText email;

    @ViewById(R.id.phone)
    MaterialEditText phone;

    @Click(R.id.sign_up)
    public void validate() {
      if(password.getText() != null && password.getText().length() >= 6) {
          Log.e("a", "afssa");
      } else {
          Toast.makeText(getActivity(), "Too short password!", Toast.LENGTH_SHORT).show();
      }
    }

}
