package com.bvblogic.examplearbvb.fragment;


import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.Random;


@EFragment(R.layout.fragment_splash)
public class SplashFragment extends BaseFragment {
    @AfterViews
    public void init() {
        BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.BLUE);
        initToolBar(ToolBarById.CLOSE);
        User user = new User();
        user.setUid(new Random().nextInt());
        user.setName("Yura1");

    }

}
