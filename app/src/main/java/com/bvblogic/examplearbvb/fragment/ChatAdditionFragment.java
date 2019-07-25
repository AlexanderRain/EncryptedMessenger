package com.bvblogic.examplearbvb.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.adapter.instruments.Adapter;
import com.bvblogic.examplearbvb.bean.instruments.InstrumentsPresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;



@EFragment(R.layout.fragment_chat_addition)
public class ChatAdditionFragment extends BaseFragment{
    @ViewById(R.id.instruments_list)
    RecyclerView recyclerView;

    @ViewById(R.id.add_chat_FAB)
    FloatingActionButton button;

    @ViewById(R.id.instrument_name_view)
    TextView instrumentNameView;

    @ViewById(R.id.chat_name)
    EditText chatNameView;

    @ViewById(R.id.username)
    EditText usernameView;

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
    }

    @Click(R.id.add_chat_FAB)
    void FABClick() {
        presenter.saveUser(adapter.getInstrument(), usernameView.getText().toString(), chatNameView.getText().toString());
        changeFragmentTo(new FragmentData(FragmentById.CHATS_FRAGMENT));
    }

    public void setFragment(Fragment fragment) {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                .replace(R.id.data_fragment, fragment)
                .commit();

    }

    public void setName(String name) {
        instrumentNameView.setText(name);
    }
}
