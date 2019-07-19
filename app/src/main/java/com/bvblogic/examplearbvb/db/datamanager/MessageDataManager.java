package com.bvblogic.examplearbvb.db.datamanager;

import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.datamanager.core.DBView;
import com.bvblogic.examplearbvb.db.domain.Message;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MessageDataManager {

    public void getManages(AppDatabase appDatabase, DBView<List<Message>> listDBView, int id) {
        listDBView.showWait();
        appDatabase.messageDao().getMessagesById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Message>>() {
                    @Override
                    public void onSuccess(List<Message> messages) {
                        listDBView.onSuccess(messages);
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
