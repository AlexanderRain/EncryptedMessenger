package com.bvblogic.examplearbvb.db.datamanager;

import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.datamanager.core.DBView;
import com.bvblogic.examplearbvb.db.datamanager.core.DataManager;
import com.bvblogic.examplearbvb.db.domain.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hanz on 08.05.2018.
 */

public class UserDataManager extends DataManager {

    public void getSingleUser(AppDatabase appDatabase, DBView<User> listDBView, int id) {
        listDBView.showWait();
        appDatabase.userDao().getUserById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<User>() {
                    @Override
                    public void onSuccess(User user) {
                        listDBView.onSuccess(user);
                        listDBView.hideWait();
                    }

                    @Override
                    public void onError(Throwable e) {
                        listDBView.onError(e);
                        listDBView.hideWait();
                    }
                });
    }
}
