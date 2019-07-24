package com.bvblogic.examplearbvb.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.db.presenter.UserChatPresenter;
import com.bvblogic.examplearbvb.fragment.core.BaseFragment;
import com.bvblogic.examplearbvb.mvp.core.FragmentById;
import com.bvblogic.examplearbvb.mvp.core.FragmentData;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import static com.bvblogic.examplearbvb.utils.Constants.PERMISSION_REQUEST_SMS;

@EFragment(R.layout.fragment_new_message)
public class NewMessageFragment extends BaseFragment {

    // This arg is injected when this fragment is created. It will be set in TextView
    @FragmentArg("chatId")
    public int chatId;

    @Bean
    UserChatPresenter userPresenter;

    @Click(R.id.btnBack)
    public void back(){
        popBackStack();
    }

    @Click(R.id.btnJournal)
    public void goToJournal(){
        changeFragmentTo(new FragmentData(FragmentById.HISTORY_MESSAGE_FRAGMENT, chatId));
    }

    @ViewById(R.id.btnEnter)
    Button btnEnter;

    @ViewById(R.id.btnSend)
    Button btnSend;

    @ViewById(R.id.fragment_container)
    RelativeLayout layout;

    @ViewById(R.id.enter_filePasword)
    MaterialEditText enter_pass;

    @Click(R.id.btnEnter)
    public void enter(){
        if(!enter_pass.getText().toString().equals("")){
            btnEnter.setVisibility(View.INVISIBLE);
            enter_pass.setVisibility(View.INVISIBLE);
            btnSend.setEnabled(true);
        }
    }


    @AfterViews
    public void init(){
        btnEnter.setVisibility(View.INVISIBLE);
        enter_pass.setVisibility(View.INVISIBLE);
        if (enter_pass.getText().toString().equals(""))
        {
            Toast toast = Toast.makeText(getContext(),"Пароль не введён.", Toast.LENGTH_SHORT);
            toast.show();
            enter_pass.setError("Это поле не может быть пустым.");
            btnEnter.setVisibility(View.VISIBLE);
            enter_pass.setVisibility(View.VISIBLE);
        }else{
            btnSend.setEnabled(true);
        }
        userPresenter.getUser(chatId);
        // request permissions
        requestPermission();
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission
                (getActivity(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.SEND_SMS},
                    PERMISSION_REQUEST_SMS);
        }
    }

}