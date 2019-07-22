package com.bvblogic.examplearbvb.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class SecondaryKeyTask extends AsyncTask<String, Void, Void>  {

    private Context context;


    public SecondaryKeyTask(Context context){
        this.context = context;
    }


    @Override
    protected Void doInBackground(String... voids) {

        String string = voids[0];

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(context.openFileOutput(Constants.KEYS_FILE_NAME, Context.MODE_PRIVATE)));
            writer.write(string);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // TODO: 22.07.2019 need to test


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
