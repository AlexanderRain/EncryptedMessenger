package com.bvblogic.examplearbvb.fragment.instruments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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

import carbon.widget.FloatingActionButton;
import carbon.widget.TextView;

@EFragment(R.layout.fragment_chat_addition)
public class ChatAdditionFragment extends BaseFragment implements ChatAdditionInstrumentView{
    @ViewById(R.id.instruments_list)
    private RecyclerView recyclerView;

    @ViewById(R.id.add_chat_FAB)
    private FloatingActionButton button;

    @ViewById(R.id.name_view)
    private TextView nameView;

    @Bean
    private Adapter adapter;

    @Bean
    InstrumentsPresenter presenter;

    @AfterViews
    public void init() {
        initToolBar(ToolBarById.CLOSE);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4, GridLayoutManager.HORIZONTAL, false));
        // TODO: resolve spanCount.

        recyclerView.setAdapter(adapter);

        button.setOnClickListener(v -> {

        });
    }

    @Override
    public void setFragment(Fragment fragment) {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                .add(R.id.data_fragment, fragment)
                .commit();

    }

    @Override
    public void setName(String name) {
        nameView.setText(name);
    }
}
