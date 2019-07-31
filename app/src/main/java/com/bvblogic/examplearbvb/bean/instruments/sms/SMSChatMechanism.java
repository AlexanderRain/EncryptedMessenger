package com.bvblogic.examplearbvb.bean.instruments.sms;

import com.bvblogic.examplearbvb.bean.instruments.ChatMechanism;
import com.bvblogic.examplearbvb.bean.sender.SenderBean;
import com.bvblogic.examplearbvb.db.domain.SendAction;


public class SMSChatMechanism implements ChatMechanism {
    private String phone;

    public SMSChatMechanism(String phone) {
        this.phone = phone;
    }

    @Override
    public void send(String message) { // TODO: SMSChatMechanism
        SenderBean senderBean = new SenderBean();
        senderBean.send(message);
    }
}
