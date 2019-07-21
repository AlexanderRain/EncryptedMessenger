package com.bvblogic.examplearbvb.db.datamanager.core;

import com.bvblogic.examplearbvb.db.dao.BaseDao;

import java.util.List;

public class DataManager {

    public <T>  void saveData(List<T> data, BaseDao<T> dao) {
        dao.insertAll(data);
    }

}
