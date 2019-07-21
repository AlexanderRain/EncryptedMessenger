package com.bvblogic.examplearbvb.db.domain;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.bvblogic.examplearbvb.db.converter.SendActionConverter;

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
    @TypeConverters({SendActionConverter.class})
    private SendAction type;

    // recipient address (email/phone)
    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "file_password")
    private String filePassword;

    @ColumnInfo(name = "user_name")
    private String recipient;

    @ColumnInfo(name = "photo")
    private String photo;

    public void setFilePassword(String filePassword) {
        this.filePassword = filePassword;
    }

    public String getFilePassword() {
        return filePassword;
    }

    public void setUserName(String recipient) {
        this.recipient = recipient;
    }

    public String getUserName() {
        return recipient;
    }

    public SendAction getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setType(SendAction type) {
        this.type = type;
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
