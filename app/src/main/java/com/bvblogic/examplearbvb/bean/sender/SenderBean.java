package com.bvblogic.examplearbvb.bean.sender;

import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.SendAction;
import com.bvblogic.examplearbvb.utils.Constants;
import com.bvblogic.examplearbvb.utils.SecondaryKeyTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.androidannotations.annotations.EBean;

@EBean
public class SenderBean extends Bean {

    private SendAction sendAction;
    private String address;
    private String filePass;
    private int primaryKeyForWhile;

    public void init(Chat chat) {
        this.sendAction = chat.getType();
        this.address = chat.getAddress();
        // we have not any data in such fields
        this.filePass = "somedata";
        //  due to we still have not primary key, i have used this
        this.primaryKeyForWhile = chat.getId();

    }

    private void beforeSending(){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        int key = 0;

        for(int i = 0; i < filePass.length(); i++){

            if (i == 0) key = filePass.charAt(i);
            else key *= filePass.charAt(i);
        }

        key *= primaryKeyForWhile;
        key %= Constants.PASSWORD_DIVIDER;

        String json = gson.toJson(key); // String json = gson.toJson(new String[]{key, others});


        SecondaryKeyTask keyTask = new SecondaryKeyTask(activity);
        keyTask.execute(json);

//      Log.d("JSON", json);
    }

    public void send(String message) {

        beforeSending();

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
