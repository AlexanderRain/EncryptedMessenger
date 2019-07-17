package com.bvblogic.examplearbvb.bean.instruments.sms;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.instruments.ChatMechanism;
import com.bvblogic.examplearbvb.bean.instruments.Instrument;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class SMSInstrument implements Instrument {
    @RootContext
    Context context;

    @Bean
    SMSInstrumentFragment fragment;

    @Override
    public SMSInstrumentFragment getFragment() {
        return fragment;
    }

    @Override
    public int getIcon() {
        return R.drawable.ic_launcher_background;
    }

    @Override
    public String getName() {
        return context.getString(R.string.sms_instrument_name);
    }

    @Override
    public String getUserName() {
        return fragment.getName();
    }

    @Override
    public ChatMechanism getChatMechanism() {
        return new SMSChatMechanism(fragment.getPhone());
    }
}
