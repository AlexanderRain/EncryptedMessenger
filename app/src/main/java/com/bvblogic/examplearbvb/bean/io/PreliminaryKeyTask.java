package com.bvblogic.examplearbvb.bean.io;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.bvblogic.examplearbvb.api.networking.core.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import okhttp3.ResponseBody;

import static com.bvblogic.examplearbvb.utils.Constants.APPLICATION_DIR;
import static com.bvblogic.examplearbvb.utils.Constants.KEYS_FILE_PATH;
import static com.bvblogic.examplearbvb.utils.Constants.KEYS_WRITE_FILE;

public class PreliminaryKeyTask extends AsyncTask<ResponseBody, Void, Void> {

    private Service.Callback<ResponseBody> callback;

    public void setCallback(Service.Callback<ResponseBody> callback) {
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(ResponseBody... rb) {
        try {
            writeKeysFile(rb[0].string());
            callback.onSuccess(rb[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeKeysFile(String jsonKeys) throws IOException {
//        Gson gson = new Gson();
        File directory = new File(Environment.getExternalStorageDirectory() + APPLICATION_DIR);
        if(!directory.exists()) {
            directory.mkdirs();
        }
        FileWriter fileWriter = new FileWriter(Environment.getExternalStorageDirectory().getAbsolutePath() + KEYS_FILE_PATH);
        fileWriter.write(jsonKeys);
        fileWriter.close();
        Log.e("FILE", "filewriter closed");
    }
}
