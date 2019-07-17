package com.bvblogic.examplearbvb.db.datamanager;

import android.view.MenuItem;

import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.datamanager.core.DBView;
import com.bvblogic.examplearbvb.db.domain.MyMessage;
import com.bvblogic.examplearbvb.db.domain.User;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MyMessageDataManager {

    public void getAllMessages(AppDatabase appDatabase, DBView<List<MyMessage>> listDBView) {
        listDBView.showWait();
        appDatabase.myMessageDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<MyMessage>>() {
                    @Override
                    public void onSuccess(List<MyMessage> myMessages) {
                        listDBView.onSuccess(myMessages);
                        listDBView.hideWait();
                    }

                    @Override
                    public void onError(Throwable e) {
                        listDBView.onError(e);
                        listDBView.hideWait();
                    }
                });
    }


    public void saveMessage(MyMessage message, AppDatabase appDatabase, DBView<Long> listDBView) {
        listDBView.showWait();
        appDatabase.myMessageDao().insertAll(message);
    }
}
