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
}
