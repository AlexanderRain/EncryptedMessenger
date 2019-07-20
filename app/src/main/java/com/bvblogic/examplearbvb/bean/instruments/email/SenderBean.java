package com.bvblogic.examplearbvb.bean.instruments.email;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.db.domain.User;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

@EBean
public class SenderBean extends Bean {





    public void showSenderDialog(User user, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = LayoutInflater.from(activity);
        final View root = inflater.inflate(R.layout.dialog_send, null);

        Button btnMail = root.findViewById(R.id.buttonMail);
        Button btnSend = root.findViewById(R.id.buttonSend);

        btnMail.setOnClickListener(view -> sendByMail(user.getEmail(),msg));
        btnSend.setOnClickListener(view -> sendBySms(user.getMobile(),msg));

        builder.setTitle("Choose type of sending")
                .setView(root)
                .setNegativeButton("Cancel", null).show();

    }


    private void sendBySms(String address, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(address, null, msg, null, null);
            Toast.makeText(activity.getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(activity.getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

    private void sendByMail(String address, String msg){
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{address});
        email.putExtra(Intent.EXTRA_SUBJECT, "");
        email.putExtra(Intent.EXTRA_TEXT, msg);
        email.setType("message/rfc822");
        activity.startActivity(Intent.createChooser(email, "Выберите email клиент :"));
    }

}
