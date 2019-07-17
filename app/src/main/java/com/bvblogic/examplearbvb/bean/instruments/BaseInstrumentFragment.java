package com.bvblogic.examplearbvb.bean.instruments;

import android.support.v4.app.Fragment;
import android.widget.EditText;

import com.bvblogic.examplearbvb.R;

import org.androidannotations.annotations.ViewById;

public abstract class BaseInstrumentFragment extends Fragment {
    @ViewById(R.id.name)
    EditText nameView;

    public String getName() {
        return nameView.getText().toString();
    }
}
