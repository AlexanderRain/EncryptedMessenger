package com.bvblogic.examplearbvb.bean.coding;

import com.bvblogic.examplearbvb.bean.instruments.ChatMechanism;
import com.bvblogic.examplearbvb.bean.instruments.Instruments;
import com.bvblogic.examplearbvb.bean.repositories.FileRepository;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.Message;
import com.bvblogic.examplearbvb.db.domain.coding.File;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class CodingPresenter {
    @Bean
    FileRepository repository;

    @Bean
    Instruments instruments;

    public void send(Message message) {
        /*File file = repository.getByChat(chat);

        Coder coder = new Coder(file);
        String encoded = coder.encode(message.getText());

        ChatMechanism mechanism = instruments.getInstrument(chat.getType().getActionName()).getChatMechanism();

        mechanism.send(encoded);
        saveMessage(message);*/
    }

    private void saveMessage(Message message) {

    }
}
