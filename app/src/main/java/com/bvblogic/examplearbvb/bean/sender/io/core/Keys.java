package com.bvblogic.examplearbvb.bean.sender.io.core;
import java.util.ArrayList;
import java.util.List;

public class Keys {
    private int key;
    private List<Group> groups = new ArrayList<>();

    @Override
    public String toString() {
        return key + groups.toString();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
