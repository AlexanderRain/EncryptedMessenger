package com.bvblogic.examplearbvb.bean.coding;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.bvblogic.examplearbvb.bean.instruments.ChatMechanism;
import com.bvblogic.examplearbvb.bean.instruments.Instruments;
import com.bvblogic.examplearbvb.bean.io.core.Keys;
import com.bvblogic.examplearbvb.bean.preference.PreferenceBean;
import com.bvblogic.examplearbvb.bean.repositories.KeysRepository;
import com.bvblogic.examplearbvb.bean.sender.SenderBean;
import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.datamanager.ChatDataManager;
import com.bvblogic.examplearbvb.db.datamanager.MessageDataManager;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.Message;
import com.bvblogic.examplearbvb.db.domain.SendAction;
import com.bvblogic.examplearbvb.db.presenter.core.Presenter;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class CodingPresenter extends com.bvblogic.examplearbvb.bean.core.Bean {

    @Bean
    PreferenceBean preferenceBean;
//
//    @Bean
//    KeysRepository repository;
    @Bean
    SenderBean senderBean;

    @Bean
    Instruments instruments;

    private Keys keys;

    public void setKeys(Keys keys) {
        this.keys = keys;
    }

    public String code(Message message) {
        Log.e("KEYS", String.valueOf(keys == null));
        Coder coder = new Coder(keys);
        String encoded = coder.encode(message.getText());
        Log.e("ENCODED", encoded);
        return encoded;
        /*File file = repository.getByChat(chat);

        ChatMechanism mechanism = instruments.getInstrument(chat.getType().getActionName()).getChatMechanism();

        mechanism.code(encoded);
        saveMessage(message);*/
    }

    public void receive(Context context, String from, String text, SendAction sendAction){
        String encoded = code(new Message(text));
        new ChatDataManager().insertMessageByTypeAndRecipient(AppDatabase.getAppDatabase(context), from, sendAction, encoded);
    }

    public void send(Message message){
        Chat chat = new ChatDataManager().getByMessage(AppDatabase.getAppDatabase(activity), message.getChatId());
        Log.e("CHAT", chat.toString());
        saveMessage(message);
        senderBean.init(chat);
        senderBean.send(code(message));
        activity.runOnUiThread(() -> Toast.makeText(activity, "Message sent", Toast.LENGTH_SHORT).show());
    }


    private void saveMessage(Message message) {
        new MessageDataManager().saveMessage(AppDatabase.getAppDatabase(activity), message);
    }
}
