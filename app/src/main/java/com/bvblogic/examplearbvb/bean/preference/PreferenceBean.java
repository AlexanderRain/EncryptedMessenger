package com.bvblogic.examplearbvb.bean.preference;

import com.bvblogic.examplearbvb.bean.preference.core.Preference;

import org.androidannotations.annotations.EBean;

@EBean
public class PreferenceBean extends Preference {

    private static final String USERNAME_KEY = "username";

    public void saveUsername(String username) {
        savePreferences(USERNAME_KEY, username);
    }

    public String getUsername() {
        return getPreferencesString(USERNAME_KEY);
    }

    public void removeUsername() {
        remove(USERNAME_KEY);
    }
}
