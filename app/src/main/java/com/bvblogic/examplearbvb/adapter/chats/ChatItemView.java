package com.bvblogic.examplearbvb.adapter.chats;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.activity.core.BaseActivity;
import com.bvblogic.examplearbvb.db.domain.Chat;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.container_chat)
public class ChatItemView extends LinearLayout {

    public ChatItemView(Context context) {
        super(context);
    }

    @ViewById(R.id.chat_userName)
    TextView userName;

    @ViewById(R.id.chat_type)
    TextView chatType;

    @ViewById(R.id.chat_name)
    TextView chatName;

    @ViewById(R.id.chat_img)
    ImageView chatImage;

    public ChatItemView(BaseActivity context) {
        super(context);
    }

    public void bind(Chat chat, int i) {
        chatName.setText(String.valueOf(chat.getChatName()));
        chatType.setText(String.valueOf(chat.getChatType()));
        userName.setText(String.valueOf(chat.getUserName()));
        //chatImage
    }


}
