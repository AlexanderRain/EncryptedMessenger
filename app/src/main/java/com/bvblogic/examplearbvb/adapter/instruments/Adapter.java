package com.bvblogic.examplearbvb.adapter.instruments;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.PointerIcon;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bvblogic.examplearbvb.adapter.core.ViewWrapper;
import com.bvblogic.examplearbvb.bean.instruments.Instrument;
import com.bvblogic.examplearbvb.fragment.instruments.ChatAdditionInstrumentView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class Adapter extends RecyclerView.Adapter {
    @RootContext
    Context context;

    @Bean
    List<Instrument> instruments;

    @Bean
    ChatAdditionInstrumentView instrumentView;

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
            instrumentView.setFragment(instrument.getFragment());
            instrumentView.setName(instrument.getName());
        });
    }

    @Override
    public int getItemCount() {
        return instruments.size();
    }
}
