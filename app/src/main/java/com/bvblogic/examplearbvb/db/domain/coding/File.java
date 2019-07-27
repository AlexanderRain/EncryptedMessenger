package com.bvblogic.examplearbvb.db.domain.coding;

import java.util.List;

public class File {
    private long number;

    private List<Group> groups;

    public File(int number, List<Group> groups) {
        this.number = number;
        this.groups = groups;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
