package com.bvblogic.examplearbvb.db.domain.coding;

import java.util.List;

public class Group {
    private int length;

    private List<Integer> keys;

    public Group(List<Integer> keys) {
        this.keys = keys;

        int length = 0;
        for (Integer key : keys)
            length += (int) Math.pow(2, Integer.toBinaryString(key).length());

        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public List<Integer> getKeys() {
        return keys;
    }
}
