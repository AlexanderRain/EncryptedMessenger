package com.bvblogic.examplearbvb.bean.repositories;

import android.os.Environment;

import com.bvblogic.examplearbvb.bean.io.core.Keys;
import com.bvblogic.examplearbvb.db.domain.Chat;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
//import com.bvblogic.examplearbvb.db.domain.coding.File;

import org.androidannotations.annotations.EBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.bvblogic.examplearbvb.utils.Constants.JSON;
import static com.bvblogic.examplearbvb.utils.Constants.KEYS_WRITE_FILE;

@EBean
public class KeysRepository {
    public Keys getByChat(Chat chat) {
        File keysFile = new File(Environment.getExternalStorageDirectory() + KEYS_WRITE_FILE + "/" + chat.getType().getActionName() + chat.getRecipient() + JSON);

        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(keysFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return gson.fromJson(reader, Keys.class);
    }
}
