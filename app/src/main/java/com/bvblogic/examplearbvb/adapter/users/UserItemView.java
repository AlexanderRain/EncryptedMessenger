package com.bvblogic.examplearbvb.adapter.users;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.activity.core.BaseActivity;
import com.bvblogic.examplearbvb.db.domain.User;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;


@EViewGroup(R.layout.item_user)
public class UserItemView extends LinearLayout {

    public UserItemView(Context context) {
        super(context);
    }

    @ViewById(R.id.name)
    TextView name;

    @SuppressLint("CheckResult")
    public void bind(User user, int i) {
        name.setText(String.valueOf(user.getUid()));
    }
}
