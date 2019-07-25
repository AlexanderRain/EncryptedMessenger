package com.bvblogic.examplearbvb.bean.user;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.bean.sender.SenderBean;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

@EBean
public class ProviderBeanUserChat extends Bean {

    @org.androidannotations.annotations.Bean
    SenderBean senderBean;

    @ViewById(R.id.messageField)
    EditText messageField;

    @ViewById(R.id.btnEnter)
    Button btnEnter;

    @ViewById(R.id.enter_file_password)
    MaterialEditText enter_pass;

    @ViewById(R.id.user_name)
    TextView chatName;

    @ViewById(R.id.chat_type)
    TextView chatType;

    @Click(R.id.btnSend)
    public void sendMessage(){
        senderBean.send(messageField.getText().toString());
    }

    public void enterFilePassword() {
        btnEnter.setVisibility(View.VISIBLE);
        enter_pass.setVisibility(View.VISIBLE);
    }

    public void initSendBean(Chat chat) {
        senderBean.init(chat);
    }

    public void setUserName(String chatName) {
        this.chatName.setText(chatName);
    }

    public void setChatType(String sendAction) {
        this.chatType.setText(sendAction);
    }
}
