package com.bvblogic.examplearbvb.fragment;

import android.widget.EditText;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.InitialBean;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.Message;
import com.bvblogic.examplearbvb.db.domain.User;
import com.bvblogic.examplearbvb.db.presenter.AuthPresenter;
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
import java.util.Random;

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
        List<User> users = new ArrayList<>();

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
        chats.add(chat);

        Chat chat1 = new Chat();
        chat1.setId(1);
        chat1.setChatName("Ann");
        chats.add(chat1);

        Chat chat2 = new Chat();
        chat2.setId(2);
        chat2.setChatName("chat");
        chats.add(chat2);

        User user = new User();
        user.setUsername("UName");
        user.setUid(0);
        user.setChat_Id(0);
        users.add(user);

        User user1 = new User();
        user1.setUsername("Ann");
        user1.setUid(1);
        user1.setChat_Id(1);
        users.add(user1);

        User user2 = new User();
        user2.setUsername("Name");
        user2.setUid(2);
        user2.setChat_Id(2);
        users.add(user2);

        initialBean.saveMessage(messages);
        initialBean.saveChat(chats);
        initialBean.saveUser(users);

    }
}
