package com.bvblogic.examplearbvb.bean.io;

import android.content.Context;
import android.os.AsyncTask;

import com.bvblogic.examplearbvb.bean.coding.CodingPresenter;
import com.bvblogic.examplearbvb.bean.io.core.Keys;
import com.bvblogic.examplearbvb.db.domain.SendAction;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.security.Key;

@EBean
public class AcceptMessageTask  extends AsyncTask<String, String, Keys> {

    @Bean
    AcceptedKeysParser acceptedKeysParser;

    @Bean
    CodingPresenter codingPresenter;

    private Context context;

    private SendAction sendAction;

    public void setSendAction(SendAction sendAction) {
        this.sendAction = sendAction;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected Keys doInBackground(String... strings) {
        Keys keys= acceptedKeysParser.getByRecipient(strings[0], sendAction.getActionName());
        codingPresenter.setKeys(keys);
        codingPresenter.receive(context, strings[0], strings[1], sendAction);
        return keys;
    }
}
