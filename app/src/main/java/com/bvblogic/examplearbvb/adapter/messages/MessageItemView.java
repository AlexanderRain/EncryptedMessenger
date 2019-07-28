package com.bvblogic.examplearbvb.adapter.messages;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.domain.Message;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.history_message_item)
public class MessageItemView extends LinearLayout {

    public MessageItemView(Context context) {
        super(context);
    }

    @ViewById(R.id.message)
    TextView text;

    @ViewById(R.id.message_type)
    TextView type;

    @ViewById(R.id.message_time)
    TextView time;

    @SuppressLint("CheckResult")
    public void bind(Message message, int i) {
        this.text.setText(String.valueOf(message.getText()));
        this.type.setText(String.valueOf(message.getType()));
        this.time.setText(String.valueOf(message.getTime()));
    }

}
