package com.bvblogic.examplearbvb.bean.user;

import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.core.Bean;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

@EBean
public class ProviderBeanUser extends Bean {

    @ViewById(R.id.tvUsername)
    TextView userName;

    public void setUserName(String userName) {
        this.userName.setText(userName);
    }
}
