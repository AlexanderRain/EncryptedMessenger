package com.bvblogic.examplearbvb.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class AuthHelper {

    public static String getAuthToken(String username, String password){
        byte[] bytes = new byte[0];
        String creditalsToEncode = username+":"+password;

        try {
            bytes = creditalsToEncode.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "Basic " + Base64.encodeToString(bytes, Base64.NO_WRAP);
    }
}
