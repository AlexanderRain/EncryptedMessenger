package com.bvblogic.examplearbvb.adapter.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.domain.Message;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

@EBean
public class HistoryMessageAdapter extends
        RecyclerView.Adapter<HistoryMessageAdapter.ViewHolder> {

    private List<Message> messageList = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_message_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(messageList.get(i));
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public void setItems(List<Message> messageList){
        this.messageList = messageList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvBodyMessage, tvMessageTime, tvTypeMessage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvBodyMessage = itemView.findViewById(R.id.tvBodyMessage);
            tvTypeMessage = itemView.findViewById(R.id.tvTypeMessage);
            tvMessageTime = itemView.findViewById(R.id.tvMessageTime);
        }

        public void bind(Message message){
            tvBodyMessage.setText(message.getText());
            tvMessageTime.setText(message.getTime());
            /*if(message.isReceived())
                tvTypeMessage.setText("received");
            else tvTypeMessage.setText("sent");*/
        }
    }
}
