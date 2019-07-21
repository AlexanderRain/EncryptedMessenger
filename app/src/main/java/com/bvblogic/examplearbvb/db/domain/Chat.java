package com.bvblogic.examplearbvb.db.domain;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "chat")
public class Chat {

    @PrimaryKey()
    @ColumnInfo(name = "id")
    @NonNull
    private int id;

    @ColumnInfo(name = "chat_name")
    private String chatName;

    // chatType = email/sms etc
    @ColumnInfo(name = "chatType")
    private String chatType;

    @ColumnInfo(name = "file_password")
    private String filePassword;

    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "photo")
    private String photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public String getFilePassword() { return filePassword; }

    public void setFilePassword(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
