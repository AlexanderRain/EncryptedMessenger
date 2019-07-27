package com.bvblogic.examplearbvb.bean.io.core;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Group {
    private List<String> keys;

    private long lenght;

    public Group(List<String> keys, long lenght) {
        this.keys = keys;
        this.lenght = lenght;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public long getLength() {
        return lenght;
    }

    public void setLenght(long lenght) {
        this.lenght = lenght;
    }
}
