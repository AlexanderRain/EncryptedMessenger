package com.bvblogic.examplearbvb.db.domain;


public class MyMessage {

    private String message;

    private String date;

    private boolean isReceived;

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public boolean isReceived(){
        return isReceived;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setReceived(boolean received) {
        this.isReceived = received;
    }


    public MyMessage(String m, String d, boolean isReceived){
        message = m; date = d; this.isReceived = isReceived;
    }
}
