package com.bvblogic.examplearbvb.db.domain.coding;

import java.util.List;

public class File {
    int number;

    List<Group> groups;

    public File(int number, List<Group> groups) {
        this.number = number;
        this.groups = groups;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
