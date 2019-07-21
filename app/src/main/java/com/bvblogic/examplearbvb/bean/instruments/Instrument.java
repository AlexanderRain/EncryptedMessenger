package com.bvblogic.examplearbvb.bean.instruments;

import android.support.annotation.DrawableRes;

import com.bvblogic.examplearbvb.db.domain.SendAction;

public interface Instrument {
    BaseInstrumentFragment getFragment();

    @DrawableRes
    int getIcon();

    SendAction getAction();

    ChatMechanism getChatMechanism();
}
