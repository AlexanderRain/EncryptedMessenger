package com.bvblogic.examplearbvb.bean.instruments.email;

import com.bvblogic.examplearbvb.bean.instruments.ChatMechanism;
import com.bvblogic.examplearbvb.bean.sender.SenderBean;
import com.bvblogic.examplearbvb.db.domain.SendAction;

public class EmailChatMechanism implements ChatMechanism {
    private String email;

    public EmailChatMechanism(String email) {
        this.email = email;
    }

    @Override
    public void send(String message) { // TODO: SMSChatMechanism
        SenderBean senderBean = new SenderBean();
        senderBean.setAddress(email);
        senderBean.setSendAction(SendAction.EMAIL);
        senderBean.send(message);
    }
}
