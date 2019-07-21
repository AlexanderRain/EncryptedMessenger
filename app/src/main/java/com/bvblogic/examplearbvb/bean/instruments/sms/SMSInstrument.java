package com.bvblogic.examplearbvb.bean.instruments.sms;

import android.content.Context;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.instruments.ChatMechanism;
import com.bvblogic.examplearbvb.bean.instruments.Instrument;
import com.bvblogic.examplearbvb.db.domain.SendAction;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class SMSInstrument implements Instrument {
    @RootContext
    Context context;

    SMSInstrumentFragment fragment = SMSInstrumentFragment_.builder().build();

    @Override
    public SMSInstrumentFragment getFragment() {
        return fragment;
    }

    @Override
    public int getIcon() {
        return R.drawable.ic_launcher_background;
    }

    @Override
    public SendAction getAction() {
        return SendAction.SMS;
    }

    @Override
    public ChatMechanism getChatMechanism() {
        return new SMSChatMechanism(fragment.getPhone());
    }
}
