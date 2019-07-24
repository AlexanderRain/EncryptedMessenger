package com.bvblogic.examplearbvb.bean.instruments.messageReceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.domain.SendAction;
import com.bvblogic.examplearbvb.db.presenter.ChatsPresenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EReceiver;
import org.androidannotations.annotations.ReceiverAction;

@EReceiver
public class SMSListener extends BroadcastReceiver {

    @Bean
    ChatsPresenter chatsPresenter;

    private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(ACTION)){
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
                    Log.d("CONTEXT_ALLLL", context.getApplicationContext().toString());
                    if(msgBody.length() > 1) {
                        String[] words = msgBody.split(" ", 2);
                        chatsPresenter.getChatByRecipientAndType(context, words[0], SendAction.SMS, words[1]);
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}
