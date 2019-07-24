package com.bvblogic.examplearbvb.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.presenter.UserChatPresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;

import static com.bvblogic.examplearbvb.utils.Constants.REQUEST_PERMISSION;

@EFragment(R.layout.fragment_new_message)
public class NewMessageFragment extends BaseFragment {

    // This arg is injected when this fragment is created. It will be set in TextView
    @FragmentArg("chatId")
    public int chatId;

    @Bean
    UserChatPresenter userPresenter;

    @Click(R.id.btnBack)
    public void back(){
        popBackStack();
    }

    @Click(R.id.btnJournal)
    public void goToJournal(){
        changeFragmentTo(new FragmentData(FragmentById.HISTORY_MESSAGE_FRAGMENT, chatId));
    }

    @AfterViews
    public void init(){
        userPresenter.getUser(chatId);
        // request permissions
        requestPermission();
    }

    private void requestPermission() {
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS)
                + ContextCompat.checkSelfPermission(
                getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                + ContextCompat.checkSelfPermission(
                getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    getActivity(),
                    new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.SEND_SMS,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    },
                    REQUEST_PERMISSION
            );
        }
    }

}