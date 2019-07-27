package com.bvblogic.examplearbvb.bean.io;

import android.os.Environment;
import android.util.Log;

import com.bvblogic.examplearbvb.bean.io.core.Keys;
import com.bvblogic.examplearbvb.db.domain.SendAction;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.androidannotations.annotations.EBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.bvblogic.examplearbvb.utils.Constants.ACCEPTED_FOLDER;
import static com.bvblogic.examplearbvb.utils.Constants.JSON;

@EBean
public class AcceptedKeysParser {

    public Keys getByRecipient(String from, String action) {
        Log.e("acc",Environment.getExternalStorageDirectory() + ACCEPTED_FOLDER + "/" + action + from + JSON );
        File keysFile = new File(Environment.getExternalStorageDirectory() + ACCEPTED_FOLDER + "/" + action + from + JSON);

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
