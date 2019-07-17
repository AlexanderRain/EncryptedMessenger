package com.bvblogic.examplearbvb.db.domain;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "messages")
public class MyMessage {

    @PrimaryKey()
    @ColumnInfo(name = "message_id")
    @NonNull
    private int messId;

    @ColumnInfo(name = "message_body")
    private String message;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "is_received")
    private boolean isReceived;

    public int getMessId() {
        return messId;
    }

    public void setMessId(int mId) {
        this.messId = mId;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public boolean isReceived(){
        return isReceived;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setReceived(boolean received) {
        this.isReceived = received;
    }

}
