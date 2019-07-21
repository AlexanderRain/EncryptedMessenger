package com.bvblogic.examplearbvb.adapter.instruments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bvblogic.examplearbvb.adapter.core.ViewWrapper;
import com.bvblogic.examplearbvb.bean.instruments.Instrument;
import com.bvblogic.examplearbvb.bean.instruments.Instruments;
import com.bvblogic.examplearbvb.fragment.ChatAdditionFragment;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class Adapter extends RecyclerView.Adapter {
    @RootContext
    Context context;

    ChatAdditionFragment fragment;

    @Bean
    Instruments availableInstruments;

    List<Instrument> instruments;

    private int current = -1;

    @AfterInject
    void init() {
        instruments = availableInstruments.getInstruments();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ImageView view = new ImageView(context);
        view.setClickable(true);
        view.setFocusable(true);
        return new ViewWrapper<>(view);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewWrapper<ImageView> wrapper = ((ViewWrapper<ImageView>) viewHolder);
        Instrument instrument = instruments.get(i);
        ImageView view = wrapper.getView();

        view.setBackground(context.getResources().getDrawable(instrument.getIcon(), context.getTheme()));
        view.refreshDrawableState();

        view.setOnClickListener(v -> {
            fragment.setFragment(instrument.getFragment());
            fragment.setName(instrument.getAction().getActionName());

            current = i;
        });
    }

    @Override
    public int getItemCount() {
        return instruments.size();
    }

    public void setFragment(ChatAdditionFragment fragment) {
        this.fragment = fragment;
    }

    public Instrument getInstrument() {
        return instruments.get(current);
    }
}
