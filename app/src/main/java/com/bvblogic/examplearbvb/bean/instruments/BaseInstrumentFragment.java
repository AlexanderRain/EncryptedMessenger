package com.bvblogic.examplearbvb.bean.instruments;

import android.support.v4.app.Fragment;
import android.widget.EditText;

import com.bvblogic.examplearbvb.R;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EBean
public abstract class BaseInstrumentFragment extends Fragment {
    @ViewById(R.id.name)
    public EditText nameView;

    public String getName() {
        return nameView.getText().toString();
    }
}
