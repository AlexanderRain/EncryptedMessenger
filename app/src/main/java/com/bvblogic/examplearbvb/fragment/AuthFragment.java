package com.bvblogic.examplearbvb.fragment;

import android.widget.EditText;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.InitialBean;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.Message;
import com.bvblogic.examplearbvb.db.domain.SendAction;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.fragment_auth)
public class AuthFragment extends BaseFragment {

    @ViewById
    EditText etLogin;

    @ViewById
    EditText etPassword;

    /*@Bean
    AuthPresenter authPresenter;*/

    @Bean
    InitialBean initialBean;

    @Click(R.id.btnLogin)
    void loginUser(){
        changeFragmentTo(new FragmentData(FragmentById.CHATS_FRAGMENT));
    }

    @Click(R.id.btnSignUp)
    void singUp(){
        changeFragmentTo(new FragmentData(FragmentById.CHATS_FRAGMENT));
    }

    @AfterViews
    public void init() {
        initToolBar(ToolBarById.CLOSE);
        BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.BLUE);
        initToolBar(ToolBarById.CLOSE);

        createData();
    }

    public void createData() {
        //testing data
        List<Message> messages = new ArrayList<>();
        List<Chat> chats = new ArrayList<>();

        Message message = new Message();
        message.setId(0);
        message.setText("msgmsgmsg");
        message.setTime("11:50");
        message.setChatId(0);
        message.setType("recieved");
        message.setUserName("Name");
        messages.add(message);

        Message message1 = new Message();
        message1.setId(1);
        message1.setText("Annnnnnnn");
        message1.setTime("00:00");
        message1.setChatId(1);
        message1.setType("recieved");
        message1.setUserName("Ann");
        messages.add(message1);

        Message message2 = new Message();
        message2.setId(2);
        message2.setText("msgmsgmsgwafwg");
        message2.setTime("11:50");
        message2.setChatId(2);
        message2.setType("recieved");
        message2.setUserName("AnotherName");
        messages.add(message2);

        Chat chat = new Chat();
        chat.setId(0);
        chat.setChatName("lalala");
        chat.setType(SendAction.SMS);
        chat.setUserName("Ann");
        chat.setAddress("0955566366");
        chats.add(chat);

        Chat chat1 = new Chat();
        chat1.setId(1);
        chat1.setChatName("Ann");
        chat1.setUserName("Ann");
        chat1.setType(SendAction.SMS);
        chat1.setAddress("0955566366");
        chats.add(chat1);

        Chat chat2 = new Chat();
        chat2.setId(2);
        chat2.setChatName("chat");
        chat2.setUserName("Ann");
        chat2.setType(SendAction.SMS);
        chat2.setAddress("0955566366");
        chats.add(chat2);

        initialBean.saveMessage(messages);
        initialBean.saveChat(chats);

    }
}
