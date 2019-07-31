package com.bvblogic.examplearbvb.adapter.messages;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.activity.core.BaseActivity;
import com.bvblogic.examplearbvb.adapter.core.RecyclerViewAdapterBase;
import com.bvblogic.examplearbvb.adapter.core.ViewWrapper;
import com.bvblogic.examplearbvb.db.domain.Message;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

@EBean
public class HistoryMessageAdapter extends RecyclerViewAdapterBase<Message, MessageItemView> {

    @RootContext
    protected BaseActivity activity;

    @Override
    protected MessageItemView onCreateItemView(ViewGroup parent, int viewType) {
        return MessageItemView_.build(activity);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<MessageItemView> messageItemViewViewWrapper, int i) {
        MessageItemView view = messageItemViewViewWrapper.getView();
        view.setTag(i);
        view.bind(items.get(i), i);
    }
}
