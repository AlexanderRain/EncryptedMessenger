package com.bvblogic.examplearbvb.adapter.chats;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.activity.core.BaseActivity;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.container_chat)
public class ChatItemView extends LinearLayout {

    BaseActivity activity;

    @ViewById(R.id.container_chat)
    RelativeLayout layout;

    @ViewById(R.id.chat_userName)
    TextView userName;

    @ViewById(R.id.chat_type)
    TextView chatType;

    @ViewById(R.id.chat_name)
    TextView chatName;

    @ViewById(R.id.chat_img)
    ImageView chatImage;

    public ChatItemView(BaseActivity activity) {
        super(activity);
        this.activity = activity;
    }

    public void bind(Chat chat, int i) {
        chatName.setText(String.valueOf(chat.getChatName()));
        chatType.setText(String.valueOf(chat.getType()));
        userName.setText(String.valueOf(chat.getRecipient()));
        layout.setOnClickListener(v ->
                activity.changeFragmentTo(new FragmentData(FragmentById.NEW_MESSAGE_FRAGMENT, chat.getId())));
    }


}
