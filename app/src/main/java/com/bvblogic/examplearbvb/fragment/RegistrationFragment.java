package com.bvblogic.examplearbvb.fragment;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_registration)
public class RegistrationFragment extends BaseFragment {

    @ViewById(R.id.user_name)
    MaterialEditText userName;

    @ViewById(R.id.password)
    MaterialEditText password;

    @ViewById(R.id.email)
    MaterialEditText email;

    @ViewById(R.id.phone)
    MaterialEditText phone;

}
