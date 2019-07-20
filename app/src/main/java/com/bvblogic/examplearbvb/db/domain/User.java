package com.bvblogic.examplearbvb.db.domain;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;


import io.reactivex.annotations.NonNull;

/**
 * Created by hanz on 08.05.2018.
 *
 *      Not to use it !!!
 */

@Entity(tableName = "user")
public class User {


    @PrimaryKey()
    @ColumnInfo(name = "user_id")
    @NonNull
    private int uid;

    @ColumnInfo(name = "chat_id")
    private int chat_Id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "telegramm")
    private String telegramm;

    @ColumnInfo(name = "mobile")
    private String mobile;

    @ColumnInfo(name = "logo")
    private String logo;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getChat_Id() {
        return chat_Id;
    }

    public void setChat_Id(int chat_Id) {
        this.chat_Id = chat_Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelegramm() {
        return telegramm;
    }

    public void setTelegramm(String telegramm) {
        this.telegramm = telegramm;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
