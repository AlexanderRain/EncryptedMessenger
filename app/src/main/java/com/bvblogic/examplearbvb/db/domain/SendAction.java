package com.bvblogic.examplearbvb.db.domain;

public enum SendAction {
    SMS("SMS"),
    EMAIL("EMAIL");

    SendAction(String actionName) {
        this.actionName = actionName;
    }

    private String actionName;

    public String getActionName() {
        return this.actionName;
    }
}
