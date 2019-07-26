package com.bvblogic.examplearbvb.bean.io;

import android.os.AsyncTask;
import android.os.Environment;

import com.bvblogic.examplearbvb.bean.coding.core.File;
import com.bvblogic.examplearbvb.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.bvblogic.examplearbvb.utils.Constants.JSON;
import static com.bvblogic.examplearbvb.utils.Constants.KEYS_FILE_PATH;
import static com.bvblogic.examplearbvb.utils.Constants.KEYS_WRITE_FILE;

public class SecondaryKeyTask extends AsyncTask<String, Integer, Integer>  {

    private Callback callback;

    public interface Callback {
        void onComplete(Integer secondaryKey);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        File file = null;
        try {
            file = readKeysFile();
            file.setNumber(generateSecondaryKey(file.getNumber(), strings[0]));
            writeKeysFile(file, strings[1], strings[2]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return file.getNumber();
    }

    private File readKeysFile() throws IOException{
        java.io.File directory = new java.io.File(Environment.getExternalStorageDirectory() + KEYS_FILE_PATH);
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(directory));

        return gson.fromJson(reader, File.class);
    }

    private void writeKeysFile(File file, String fileName, String chatType) throws IOException {
        java.io.File directory = new java.io.File(Environment.getExternalStorageDirectory() + KEYS_WRITE_FILE);
        if(!directory.exists()) {
            directory.mkdirs();
        }
        Gson gson = new Gson();
        String json = gson.toJson(file);
        FileWriter fileWriter = new FileWriter(Environment.getExternalStorageDirectory() + KEYS_WRITE_FILE + "/" + chatType + fileName + JSON);
        fileWriter.write(json);
        fileWriter.close();
    }

    private int generateSecondaryKey(int primaryKey, String filePass){
        int key = 1;
        for(int i = 0; i < filePass.length(); i++){
            key *= filePass.charAt(i);
        }

        key *= primaryKey;
        key %= Constants.PASSWORD_DIVIDER;
        return key;
    }

    @Override
    protected void onPostExecute(Integer secondaryKey) {
        super.onPostExecute(secondaryKey);
//        callback.onComplete(secondaryKey);
    }
}
