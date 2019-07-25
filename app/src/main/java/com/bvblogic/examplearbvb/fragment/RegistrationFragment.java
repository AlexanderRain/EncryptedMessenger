package com.bvblogic.examplearbvb.fragment;

import android.util.Log;
import android.util.LogPrinter;
import android.widget.Toast;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.api.model.User;
import com.bvblogic.examplearbvb.api.presenter.RegisterPresenter;
import com.bvblogic.examplearbvb.bean.register.RegisterBean;
import com.bvblogic.examplearbvb.bean.register.RegisterBeanView;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_registration)
public class RegistrationFragment extends BaseFragment {

    @Bean
    RegisterBeanView registerBeanView;

}
