package com.bvblogic.examplearbvb.bean.io.core;
import java.util.ArrayList;
import java.util.List;

public class Keys {
    private long number;
    private List<Group> groups = new ArrayList<>();

    @Override
    public String toString() {
        return number + groups.toString();
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
