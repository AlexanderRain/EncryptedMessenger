package com.bvblogic.examplearbvb.fragment;

import android.widget.Button;
import android.widget.TextView;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_new_message)
public class NewMessageFragment extends BaseFragment {
    @ViewById
    public Button btnJournal;

    @ViewById
    public Button btnSend;

    @ViewById
    public MaterialEditText messageField;

    @ViewById
    public TextView userName;

    @Click(R.id.btnBack)
    public void back() {

    }
}