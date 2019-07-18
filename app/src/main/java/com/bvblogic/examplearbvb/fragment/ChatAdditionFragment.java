package com.bvblogic.examplearbvb.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.adapter.instruments.Adapter;
import com.bvblogic.examplearbvb.bean.instruments.InstrumentsPresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;



@EFragment(R.layout.fragment_chat_addition)
public class ChatAdditionFragment extends BaseFragment{
    @ViewById(R.id.instruments_list)
    RecyclerView recyclerView;

    @ViewById(R.id.add_chat_FAB)
    FloatingActionButton button;

    @ViewById(R.id.name_view)
    TextView nameView;

    @Bean
    Adapter adapter;

    @Bean
    InstrumentsPresenter presenter;
    @AfterViews
    public void init() {
        initToolBar(ToolBarById.CLOSE);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4, GridLayoutManager.VERTICAL, false));
        // TODO: resolve spanCount.

        adapter.setFragment(this);
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            presenter.saveUser(adapter.getInstrument());
        });
    }

    public void setFragment(Fragment fragment) {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                .replace(R.id.data_fragment, fragment)
                .commit();

    }

    public void setName(String name) {
        nameView.setText(name);
    }
}
