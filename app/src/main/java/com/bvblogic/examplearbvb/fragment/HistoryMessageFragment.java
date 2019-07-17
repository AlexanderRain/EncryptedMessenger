package com.bvblogic.examplearbvb.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.adapter.activities.HistoryMessageAdapter;
import com.bvblogic.examplearbvb.db.domain.MyMessage;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.fragment_message_history)
public class HistoryMessageFragment extends BaseFragment {

    @ViewById
    RecyclerView recycler;


    @AfterViews
    public void init() {
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        HistoryMessageAdapter adapter = new HistoryMessageAdapter();

        recycler.setAdapter(adapter);

        List<MyMessage> list = new ArrayList<>();
        list.add(new MyMessage("sdagsdgl;aglskd;g", "13.2321.2", true));
        list.add(new MyMessage("sdagsdgl;aglskd;g", "13.2321.2", true));
        list.add(new MyMessage("sdagsdgl;aglskd;g", "13.2321.2", true));
        adapter.setItems(list);
        // BaseFragment.changeColorBar(getActivity(), BaseFragment.ColorBar.BLUE);
        // initToolBar(ToolBarById.CLOSE);
    }

}
