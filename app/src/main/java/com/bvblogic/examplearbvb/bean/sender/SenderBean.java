package com.bvblogic.examplearbvb.bean.sender;

import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.bean.io.SecondaryKeyTask;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.SendAction;

import org.androidannotations.annotations.EBean;

@EBean
public class SenderBean extends Bean {

    private SendAction sendAction;
    private String address;
    public void init(Chat chat) {
        this.sendAction = chat.getType();
        this.address = chat.getAddress();
    }

    public void encryptMessage(String message) {
        SecondaryKeyTask task = new SecondaryKeyTask();
        task.execute();
        send(message);
    }

    public void send(String message) {
        switch(sendAction){
            case SMS:
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(address, null, message, null, null);
                    Toast.makeText(activity.getApplicationContext(), "Message Sent",
                            Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(activity.getApplicationContext(),ex.getMessage(),
                            Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
                break;

            case EMAIL:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{address});
                email.putExtra(Intent.EXTRA_SUBJECT, "");
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                activity.startActivity(Intent.createChooser(email, "Выберите email клиент :"));
                break;
        }
    }

}
