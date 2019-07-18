package com.bvblogic.examplearbvb.bean.instruments.email;

import android.widget.EditText;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.instruments.BaseInstrumentFragment;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_email_instrument)
public class EmailInstrumentFragment extends BaseInstrumentFragment {
    @ViewById(R.id.phone)
    EditText emailView;

    public String getEmail() {
        return emailView.getText().toString();
    }
}
