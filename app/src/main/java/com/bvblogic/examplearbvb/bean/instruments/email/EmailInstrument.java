package com.bvblogic.examplearbvb.bean.instruments.email;

import android.content.Context;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.instruments.ChatMechanism;
import com.bvblogic.examplearbvb.bean.instruments.Instrument;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class EmailInstrument implements Instrument {
    @RootContext
    Context context;

    EmailInstrumentFragment fragment = EmailInstrumentFragment_.builder().build();

    @Override
    public EmailInstrumentFragment getFragment() {
        return fragment;
    }

    @Override
    public int getIcon() {
        return R.drawable.ic_launcher_foreground;
    }

    @Override
    public String getName() {
        return context.getString(R.string.email_instrument_name);
    }

    @Override
    public ChatMechanism getChatMechanism() {
        return new EmailChatMechanism(fragment.getEmail());
    }
}
