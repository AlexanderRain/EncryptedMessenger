package com.bvblogic.examplearbvb.activity.core;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.password.BeanPassword;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.bvblogic.examplearbvb.mvp.core.FragmentFeedback;
import com.bvblogic.examplearbvb.mvp.core.ToolBarById;
import com.bvblogic.examplearbvb.mvp.manager.core.core.ManagerUI;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

/**
 * Created by hanz on 7.05.18.
 */
@EActivity
public abstract class BaseActivity extends AppCompatActivity implements FragmentFeedback {

    private ManagerUI managerUI;

    @Bean
    public BeanPassword beanPassword;

    @AfterViews
    public void initManager() {
        managerUI = this.getManagerUIToInit();
    }

    protected abstract ManagerUI getManagerUIToInit();

    public void createDialog(int id, String pass) {
        if(pass == null) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            View v = inflater.inflate(R.layout.dialog_password, null);
            dialog.setView(v)
                    .setPositiveButton(R.string.positive_button, (dialog1, which) -> {
                        MaterialEditText editText = v.findViewById(R.id.enter_file_password);
                        if(editText.getText() == null || editText.getText().toString().length() < 6) {
                            Toast.makeText(this, "Too short password!", Toast.LENGTH_SHORT).show();
                            editText.setError("Too short password!");
                        } if(editText.getText().toString().length() > 8) {
                            Toast.makeText(this, "Password must be from 6 to 8 chars!", Toast.LENGTH_SHORT).show();
                            editText.setError("Password must be from 6 to 8 chars!");
                        } else {
                            beanPassword.setChatPassword(editText.getText().toString(), id);
                            beanPassword.saveFile(editText.getText().toString(), id);
                        }
                    })
                    .setNegativeButton(R.string.cancel, (dialog1, which) -> {
                        dialog1.cancel();
                    });
            dialog.create().show();
        } else {
            changeFragmentTo(new FragmentData(FragmentById.NEW_MESSAGE_FRAGMENT, id));
        }
    }

    @Override
    public void changeFragmentTo(FragmentData fragment) {
        this.managerUI.changeFragmentTo(fragment);
    }

    @Override
    public void initToolBar(BaseFragment baseFragment, ToolBarById toolBarById, String... label) {
        this.managerUI.initToolbar(baseFragment, toolBarById, label);
    }

    public void popBackStack() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        BaseFragment.changeColorBar(this, BaseFragment.ColorBar.WHITE_DARK);
        if (!managerUI.removeFragment()) {
            super.onBackPressed();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (permissions[0].equals(Manifest.permission.SEND_SMS)) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                onBackPressed();
            }
        }
    }
}
