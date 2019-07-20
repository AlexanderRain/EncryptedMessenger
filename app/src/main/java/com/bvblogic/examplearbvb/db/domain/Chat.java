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

    // type = email/sms etc
    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "file_password")
    private String filePassword;

    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "photo")
    private String photo;

    public void setFilePassword(String filePassword) {
        this.filePassword = filePassword;
    }

    public String getFilePassword() {
        return filePassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
