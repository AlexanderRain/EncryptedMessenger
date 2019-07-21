package com.bvblogic.examplearbvb.adapter.chats;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.bvblogic.examplearbvb.activity.core.BaseActivity;
import com.bvblogic.examplearbvb.adapter.core.RecyclerViewAdapterBase;
import com.bvblogic.examplearbvb.adapter.core.ViewWrapper;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class ChatsAdapter extends RecyclerViewAdapterBase<Chat, ChatItemView> {

    @RootContext
    protected BaseActivity activity;

    @Override
    protected ChatItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ChatItemView_.build(activity);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<ChatItemView> chatItemViewViewWrapper, int i) {
        ChatItemView view = chatItemViewViewWrapper.getView();
        Chat chat = items.get(i);
        view.setTag(i);
        view.bind(chat, i);
        view.setOnClickListener(v ->
                activity.changeFragmentTo(new FragmentData(FragmentById.NEW_MESSAGE_FRAGMENT, chat.getId())));

    }
}
