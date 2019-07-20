package com.bvblogic.examplearbvb.bean.instruments;

import android.support.annotation.DrawableRes;

public interface Instrument {
    BaseInstrumentFragment getFragment();

    @DrawableRes
    int getIcon();

    String getName();

    ChatMechanism getChatMechanism();
}
