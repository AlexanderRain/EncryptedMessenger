package com.bvblogic.examplearbvb.bean.sender;

import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.bean.io.SecondaryKeyTask;
import com.bvblogic.examplearbvb.bean.preference.PreferenceBean;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.SendAction;

import org.androidannotations.annotations.EBean;

import static com.bvblogic.examplearbvb.utils.Constants.WHITE_SPACE;

@EBean
public class SenderBean extends Bean implements SecondaryKeyTask.Callback{

    @org.androidannotations.annotations.Bean
    PreferenceBean preferenceBean;

    private SendAction sendAction;
    private String address;
    private String password;

    public void init(Chat chat) {
        this.sendAction = chat.getType();
        this.address = chat.getAddress();
        this.password = chat.getFilePassword();
    }


    public void setSendAction(SendAction sendAction) {
        this.sendAction = sendAction;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void encryptMessage(String message) {
        //code(message);
    }

    public void send(String message) {
        switch(sendAction){
            case SMS:
                try {
//                    Log.e("ADDDSYSTU", address);
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(address, null,
                            preferenceBean.getUsername() + WHITE_SPACE + message, null, null);
                    Log.e("Message sent", "ysys");
//                    Toast.makeText(activity, "Message Sent",
//                            Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
//                    Toast.makeText(activity,ex.getMessage(),
//                            Toast.LENGTH_LONG).show();
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

    @Override
    public void onComplete(Integer secondaryKey) {

    }
}
