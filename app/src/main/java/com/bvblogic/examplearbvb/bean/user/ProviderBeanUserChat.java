package com.bvblogic.examplearbvb.bean.user;

import android.widget.EditText;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.bean.sender.SenderBean;
import com.bvblogic.examplearbvb.db.domain.Chat;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

@EBean
public class ProviderBeanUserChat extends Bean {

    @org.androidannotations.annotations.Bean
    SenderBean senderBean;

    @ViewById(R.id.messageField)
    EditText messageField;

    @ViewById(R.id.user_name)
    TextView chatName;

    @ViewById(R.id.chat_type)
    TextView chatType;

    @Click(R.id.btnSend)
    public void sendMessage(){
        senderBean.send(messageField.getText().toString());
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
