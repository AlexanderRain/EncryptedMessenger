package com.bvblogic.examplearbvb.db.converter;

import android.arch.persistence.room.TypeConverter;

import com.bvblogic.examplearbvb.db.domain.SendAction;

import static com.bvblogic.examplearbvb.utils.Constants.EMAIL_ACTION;
import static com.bvblogic.examplearbvb.utils.Constants.SMS_ACTION;

public class SendActionConverter {

    @TypeConverter
    public String fromSendAction(SendAction action) {
        switch(action){
            case SMS:
                return SMS_ACTION;
            case EMAIL:
                return EMAIL_ACTION;
                default:
                    return SMS_ACTION;
        }
    }

    @TypeConverter
    public SendAction toSendAction(String action) {
        switch(action){
            case SMS_ACTION:
                return SendAction.SMS;
            case EMAIL_ACTION:
                return SendAction.EMAIL;
                default:
                    return SendAction.SMS;
        }
    }
}
