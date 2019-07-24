package com.bvblogic.examplearbvb.bean.sender.io;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.bvblogic.examplearbvb.bean.sender.io.core.Keys;
import com.bvblogic.examplearbvb.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.bvblogic.examplearbvb.utils.Constants.JSON;
import static com.bvblogic.examplearbvb.utils.Constants.KEYS_FILE_PATH;
import static com.bvblogic.examplearbvb.utils.Constants.KEYS_WRITE_FILE;

public class SecondaryKeyTask extends AsyncTask<String, Integer, Integer>  {

    @Override
    protected Integer doInBackground(String... voids) {
        Keys keys = null;
        try {
            keys = readKeysFile();
            keys.setKey(generateSecondaryKey(keys.getKey()));
            writeKeysFile(keys);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keys.getKey();
    }

    private Keys readKeysFile() throws IOException{
        File directory = new File(Environment.getExternalStorageDirectory() + KEYS_FILE_PATH);
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(directory));

        return gson.fromJson(reader, Keys.class);
    }

    private void writeKeysFile(Keys keys) throws IOException {
        Log.e("sa",  keys.getGroups().toString());
        File directory = new File(Environment.getExternalStorageDirectory() + KEYS_WRITE_FILE);
        if(!directory.exists()) {
            directory.mkdirs();
        }
        Gson gson = new Gson();
        String json = gson.toJson(keys);
        FileWriter fileWriter = new FileWriter(Environment.getExternalStorageDirectory() + KEYS_WRITE_FILE + "/asf" + JSON);
        fileWriter.write(json);
        fileWriter.close();
    }

    private int generateSecondaryKey(int primaryKey){
        String sPrimaryKey = String.valueOf(primaryKey);
        int key = 1;

        for(int i = 0; i < sPrimaryKey.length(); i++){
            key *= sPrimaryKey.charAt(i);
        }

        key *= primaryKey;
        key %= Constants.PASSWORD_DIVIDER;
        return key;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }
}
