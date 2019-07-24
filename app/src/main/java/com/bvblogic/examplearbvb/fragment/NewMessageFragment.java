package com.bvblogic.examplearbvb.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.activity.core.BaseActivity;
import com.bvblogic.examplearbvb.bean.sender.SenderBean;
import com.bvblogic.examplearbvb.db.domain.SendAction;
import com.bvblogic.examplearbvb.db.presenter.UserChatPresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;

import static com.bvblogic.examplearbvb.utils.Constants.PERMISSION_REQUEST_READ_FILE;
import static com.bvblogic.examplearbvb.utils.Constants.PERMISSION_REQUEST_SMS;
import static com.bvblogic.examplearbvb.utils.Constants.PERMISSION_REQUEST_WRITE_FILE;

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
        if (ContextCompat.checkSelfPermission
                (getActivity(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.SEND_SMS},
                    PERMISSION_REQUEST_SMS);
        }

        if (ContextCompat.checkSelfPermission
                (getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_READ_FILE);
        }

        if (ContextCompat.checkSelfPermission
                (getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_WRITE_FILE);
        }
    }

}