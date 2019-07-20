package com.bvblogic.examplearbvb.fragment;

import android.widget.EditText;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.instruments.email.SenderBean;
import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.datamanager.UserDataManager;
import com.bvblogic.examplearbvb.db.domain.User;
import com.bvblogic.examplearbvb.db.presenter.UserPresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_new_message)
public class NewMessageFragment extends BaseFragment {

    // This arg is injected when this fragment is created. It will be set in TextView
    @FragmentArg("chatId")
    public int chatId;

    @Bean
    UserPresenter userPresenter;

    @Bean
    SenderBean senderBean;

    @ViewById(R.id.messageField)
    EditText messageField;

    @Click(R.id.btnBack)
    public void back(){
        popBackStack();
    }

    @Click(R.id.btnSend)
    public void sendMessage(){
        String message = messageField.getText().toString();

        User user = userPresenter.user;

        senderBean.showSenderDialog(user, message);
    }


    @Click(R.id.btnJournal)
    public void goToJournal(){
        changeFragmentTo(new FragmentData(FragmentById.HISTORY_MESSAGE_FRAGMENT, chatId));
    }

    @AfterViews
    public void init(){
        userPresenter.getUser(chatId);
    }
}