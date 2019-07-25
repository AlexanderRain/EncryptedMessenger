package com.bvblogic.examplearbvb.bean.password;

import android.widget.Toast;

import com.bvblogic.examplearbvb.bean.core.Bean;
import com.bvblogic.examplearbvb.db.core.AppDatabase;
import com.bvblogic.examplearbvb.db.datamanager.ChatDataManager;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;

import org.androidannotations.annotations.EBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

@EBean
public class BeanPassword extends Bean {

    public void setChatPassword(String password, int id) {
        new ChatDataManager().updatePassword(id, password,  AppDatabase.getAppDatabase(activity))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        activity.changeFragmentTo(new FragmentData(FragmentById.NEW_MESSAGE_FRAGMENT, id));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(activity, "", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
