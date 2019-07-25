package com.bvblogic.examplearbvb.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.EditText;
import android.widget.Toast;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.InitialBean;
import com.bvblogic.examplearbvb.bean.auth.LoginBeanView;
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

import static com.bvblogic.examplearbvb.utils.Constants.REQUEST_PERMISSION;

@EFragment(R.layout.fragment_auth)
public class AuthFragment extends BaseFragment {

    @Bean
    LoginBeanView loginBeanView;

    @ViewById
    EditText etLogin;

    @ViewById
    EditText etPassword;

    @Bean
    InitialBean initialBean;

    @Click(R.id.btnLogin)
    void loginUser(){
        if(!etLogin.getText().toString().equals("") && !etPassword.getText().toString().equals("")){
            loginBeanView.login(etLogin.getText().toString(),
                    etPassword.getText().toString()
            );
        } else {
            Toast.makeText(getActivity(), "Please fill all the fields!", Toast.LENGTH_SHORT).show();
        }

    }

    @Click(R.id.btnSignUp)
    void singUp(){
        changeFragmentTo(new FragmentData(FragmentById.REGISTRATION_FRAGMENT));
    }

    @AfterViews
    public void init() {
        initToolBar(ToolBarById.CLOSE);
        BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.BLUE);
        initToolBar(ToolBarById.CLOSE);
        requestPermission();
        createData();
    }

    private void requestPermission() {
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS)
                + ContextCompat.checkSelfPermission(
                getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                + ContextCompat.checkSelfPermission(
                getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE
                        + ContextCompat.checkSelfPermission
                        (getActivity(), Manifest.permission.RECEIVE_SMS))
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    getActivity(),
                    new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.SEND_SMS,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.RECEIVE_SMS
                    },
                    REQUEST_PERMISSION
            );
        }
    }

    public void createData() {
        //testing data
        List<Message> messages = new ArrayList<>();
        List<Chat> chats = new ArrayList<>();

        Message message1 = new Message();
        message1.setId(1);
        message1.setText("Annnnnnnn");
        message1.setTime("00:00");
        message1.setChatId(1);
        message1.setType("recieved");
        message1.setUserName("Ann");
        messages.add(message1);

        Chat chat1 = new Chat();
        chat1.setId(1);
        chat1.setChatName("Ann");
        chat1.setRecipient("Ann");
        chat1.setType(SendAction.SMS);
        chat1.setAddress("0955566366");
        chats.add(chat1);

        initialBean.saveMessage(messages);
        initialBean.saveChat(chats);

    }
}
