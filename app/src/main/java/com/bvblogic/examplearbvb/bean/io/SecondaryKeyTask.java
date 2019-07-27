package com.bvblogic.examplearbvb.bean.io;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

//import com.bvblogic.examplearbvb.bean.coding.core.File;
import com.bvblogic.examplearbvb.bean.coding.CodingPresenter;
import com.bvblogic.examplearbvb.bean.io.core.Keys;
import com.bvblogic.examplearbvb.utils.Constants;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.bvblogic.examplearbvb.utils.Constants.ACCEPTED_FOLDER;
import static com.bvblogic.examplearbvb.utils.Constants.JSON;
import static com.bvblogic.examplearbvb.utils.Constants.KEYS_FILE_PATH;
import static com.bvblogic.examplearbvb.utils.Constants.KEYS_WRITE_FILE;
import static com.bvblogic.examplearbvb.utils.Constants.TEMP_FOLDER;

public class SecondaryKeyTask extends AsyncTask<String, Long, Long>  {

    private Callback callback;

    public interface Callback {
        void onComplete(Integer secondaryKey);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected Long doInBackground(String... strings) {
        Keys file = null;
        try {

            file = readKeysFile();
            file.setNumber(generateSecondaryKey(file.getNumber(), strings[0]));
            String src = writeKeysFile(file, strings[3], strings[2]);
            cleanAllFilesInTemp();
            Files.copy(new File(src), new File(Environment.getExternalStorageDirectory() + TEMP_FOLDER + "/" + strings[2] +  strings[1] + JSON));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return file.getNumber();
    }

    private Keys readKeysFile() throws IOException{
        java.io.File directory = new java.io.File(Environment.getExternalStorageDirectory() + KEYS_FILE_PATH);
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(directory));

        return gson.fromJson(reader, Keys.class);
    }

    private String writeKeysFile(Keys file, String fileName, String chatType) throws IOException {
        java.io.File directory = new java.io.File(Environment.getExternalStorageDirectory() + KEYS_WRITE_FILE);
        if(!directory.exists()) {
            Log.e("NNNN", "no such dir!");
            directory.mkdirs();
        }
        Gson gson = new Gson();
        String json = gson.toJson(file);
        String filename = Environment.getExternalStorageDirectory() + KEYS_WRITE_FILE + "/" + chatType + fileName + JSON;
        Log.e("Filename", filename);
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write(json);
        fileWriter.close();

        return filename;
    }

    private long generateSecondaryKey(long primaryKey, String filePass){
        long key = 1;
        for(int i = 0; i < filePass.length(); i++){
            key *= filePass.charAt(i);
        }

        key %= Constants.PASSWORD_DIVIDER;
        key *= primaryKey;
        key %= Constants.PASSWORD_DIVIDER;
        return key;
    }

    @Override
    protected void onPostExecute(Long secondaryKey) {
        super.onPostExecute(secondaryKey);
//        callback.onComplete(secondaryKey);
    }

    private void cleanAllFilesInTemp(){
        java.io.File directoryAccepted = new java.io.File(Environment.getExternalStorageDirectory() + ACCEPTED_FOLDER);
        if(!directoryAccepted.exists()) {
            directoryAccepted.mkdirs();
        }
        java.io.File directory = new java.io.File(Environment.getExternalStorageDirectory() + TEMP_FOLDER);
        if(!directory.exists()){
            directory.mkdirs();
        } else {
            String[] allFiles = directory.list();
            for (String s : allFiles){
                java.io.File f = new File(directory.getPath(), s);
                f.delete();
            }
        }

    }
}
