package com.bvblogic.examplearbvb.bean.instruments;

import com.bvblogic.examplearbvb.bean.instruments.email.EmailInstrument;
import com.bvblogic.examplearbvb.bean.instruments.sms.SMSInstrument;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.Arrays;
import java.util.List;

@EBean
public class Instruments {
    @Bean
    EmailInstrument emailInstrument;

    @Bean
    SMSInstrument smsInstrument;

    public List<Instrument> getInstruments() {
        return Arrays.asList(smsInstrument, emailInstrument);
    }

    public Instrument getInstrument(String name) {
        if (name.equals(emailInstrument.getAction().getActionName()))
            return emailInstrument;
        else if (name.equals(smsInstrument.getAction().getActionName()))
            return smsInstrument;
        else
            throw new IllegalArgumentException("There isn't such instrument.");
    }
}
