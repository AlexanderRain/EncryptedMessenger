package com.bvblogic.examplearbvb.bean.instruments.email;

import com.bvblogic.examplearbvb.bean.instruments.ChatMechanism;

public class EmailChatMechanism implements ChatMechanism {
    private String email;

    public EmailChatMechanism(String email) {
        this.email = email;
    }

    @Override
    public void send(String message) { // TODO: SMSChatMechanism

    }
}
