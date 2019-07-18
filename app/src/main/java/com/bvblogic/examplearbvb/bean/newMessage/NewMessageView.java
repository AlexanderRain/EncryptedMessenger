package com.bvblogic.examplearbvb.bean.newMessage;

import android.widget.EditText;

import com.bvblogic.examplearbvb.R;
import com.bvblogic.examplearbvb.bean.core.Bean;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

@EBean
public class NewMessageView extends Bean {

    @ViewById
    EditText messageField;

    @Click(R.id.btnBack)
    public void back(){
//        activity.changeFragmentTo(new FragmentData(FragmentById.));
    }

    @Click(R.id.btnSend)
    public void sendMessage(){

        String message = messageField.getText().toString();
        if(!message.equals("")){

        }
    }

    @Click(R.id.btnJournal)
    public void goToJournal(){
//        activity.changeFragmentTo(new FragmentData(FragmentById.));
    }



}
