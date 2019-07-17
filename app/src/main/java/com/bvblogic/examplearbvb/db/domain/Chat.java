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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
