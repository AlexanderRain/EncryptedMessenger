package com.bvblogic.examplearbvb.bean.instruments;

import android.graphics.drawable.Icon;
import android.support.v4.app.Fragment;

import androidx.annotation.DrawableRes;

import javax.annotation.Resource;

public interface Instrument {
    BaseInstrumentFragment getFragment();

    @DrawableRes
    int getIcon();

    String getName();

    String getUserName();

    ChatMechanism getChatMechanism();
}
