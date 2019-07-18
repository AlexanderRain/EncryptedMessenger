package com.bvblogic.examplearbvb.bean.instruments.sms;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.widget.EditText;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.instruments.BaseInstrumentFragment;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_sms_instrument)
public class SMSInstrumentFragment extends BaseInstrumentFragment {
    @ViewById(R.id.phone)
    EditText phoneView;

    public String getPhone() {
        return phoneView.getText().toString();
    }
}
