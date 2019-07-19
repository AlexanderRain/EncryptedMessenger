package com.bvblogic.examplearbvb.db.presenter;


import com.bvblogic.examplearbvb.bean.user.ProviderBeanUser;
import com.bvblogic.examplearbvb.db.datamanager.UserDataManager;
import com.bvblogic.examplearbvb.db.domain.User;
import com.bvblogic.examplearbvb.db.presenter.core.Presenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by hanz on 08.05.2018.
 */

@EBean
public class UserPresenter extends Presenter<User> {

    @Bean
    ProviderBeanUser view;

    public void getUser(int id) {
        new UserDataManager().getSingleUser(appDatabase, this, id);
    }

    @Override
    public void onSuccess(User user) {
        view.setUserName(user.getUsername());
    }
}
