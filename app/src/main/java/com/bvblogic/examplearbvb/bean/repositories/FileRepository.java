package com.bvblogic.examplearbvb.bean.repositories;

import com.bvblogic.examplearbvb.db.domain.Chat;
import com.bvblogic.examplearbvb.db.domain.coding.File;

import org.androidannotations.annotations.EBean;

@EBean
public class FileRepository {
    public File getByChat(Chat chat) {
        return null; //TODO: file getting
    }
}
