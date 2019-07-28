package com.bvblogic.examplearbvb.bean.messageReceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import com.bvblogic.examplearbvb.bean.coding.CodingPresenter;
import com.bvblogic.examplearbvb.bean.io.AcceptMessageTask;
import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.datamanager.ChatDataManager;
import com.bvblogic.examplearbvb.db.domain.SendAction;
import com.bvblogic.examplearbvb.db.presenter.ChatsPresenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EReceiver;

import static com.bvblogic.examplearbvb.utils.Constants.SMS_ACTION;

@EReceiver
public class SMSListener extends BroadcastReceiver {

    @Bean
    ChatsPresenter chatsPresenter;

//    @Bean
//    CodingPresenter codingPresenter;

    @Bean
    AcceptMessageTask acceptMessageTask;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(SMS_ACTION)){
            Bundle bundle = intent.getExtras();
            SmsMessage[] smsMessages = null;
            String msgFrom;
            String msgBody = "";
            if(bundle != null) {
                try {
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    smsMessages = new SmsMessage[pdus.length];
                    for (int i = 0; i < smsMessages.length; i++) {
                        smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                        msgFrom = smsMessages[i].getOriginatingAddress();
                        msgBody = smsMessages[i].getMessageBody();
                    }
                    if(msgBody.length() > 1) {
                        String[] words = msgBody.split(" ", 2);
                        Log.d("USER", words[0]);
                        Log.d("TEXT", words[1]);
                        // TODO: call receive from codeing presenter (number of sender)
//                        new ChatDataManager().insertMessageByTypeAndRecipient(AppDatabase.getAppDatabase(context), words[0], SendAction.SMS, words[1]);
//                        codingPresenter.receive(context, words[0], words[1], SendAction.SMS);
                        acceptMessageTask.setContext(context);
                        acceptMessageTask.setSendAction(SendAction.SMS);
                        acceptMessageTask.execute(words[0], words[1]);
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}
