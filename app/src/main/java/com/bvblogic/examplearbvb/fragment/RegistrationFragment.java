package com.bvblogic.examplearbvb.fragment;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.auth.RegisterBeanView;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_registration)
public class RegistrationFragment extends BaseFragment {

    @Bean
    RegisterBeanView registerBeanView;
}
