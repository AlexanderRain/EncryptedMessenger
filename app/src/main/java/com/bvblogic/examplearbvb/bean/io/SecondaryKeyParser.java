package com.bvblogic.examplearbvb.bean.io;

import android.os.Environment;

import com.bvblogic.examplearbvb.bean.io.core.Keys;
import com.bvblogic.examplearbvb.bean.preference.PreferenceBean;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.bvblogic.examplearbvb.utils.Constants.JSON;
import static com.bvblogic.examplearbvb.utils.Constants.KEYS_WRITE_FILE;

@EBean
public class SecondaryKeyParser {

    @Bean
    PreferenceBean preferenceBean;

    public Keys getByChat(Chat chat) {
        File keysFile = new File(Environment.getExternalStorageDirectory() + KEYS_WRITE_FILE + "/" + chat.getType().getActionName() + preferenceBean.getUsername() + JSON);

        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(keysFile));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return gson.fromJson(reader, Keys.class);
    }
}
