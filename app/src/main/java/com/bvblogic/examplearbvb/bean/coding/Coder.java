package com.bvblogic.examplearbvb.bean.coding;

import android.util.Log;

import com.bvblogic.examplearbvb.bean.io.core.Group;
import com.bvblogic.examplearbvb.bean.io.core.Keys;
import com.bvblogic.examplearbvb.db.domain.coding.File;

import java.time.LocalDate;
import java.util.Date;


public class Coder {
    private static final int MAX = 34;
    private static final int MIN = 8;

    private Keys keys;

    private int key;

    private int textLength;

    private int keyLength;

    private short phase;

//    private int groupNumber;

    private int keyNumber;

    private Group group;


    public Coder(Keys keys) {
        this.keys = keys;
    }

    public String encode(String text) {
        Log.e("TEXT Coder", text);
        Log.e("KEYS", keys.toString());
        Group group = getGroup(34, text.length() * Character.SIZE);
        char[] parsedText = text.toCharArray();
        textLength = parsedText.length;


        key = getKey(group, keys.getNumber()); // 1st iteration
        keyLength = getKeyLength(key);
        Log.e("KEY", Integer.toBinaryString(key));
        phase = getPhase(keys.getNumber());
        Log.e("PHASE", Integer.toBinaryString(phase));
        Log.e("KEYLENGTH", String.valueOf(keyLength));
        for (int i = 0; i < textLength; i++)
            parsedText[i] = encodeSymbol(parsedText[i]);


        for (int i = 0; i <= 3; i++) { // other iterations
            group = getNextGroup(textLength);
            key = getKey(group, keys.getNumber());
            phase = (short) (phase << 1);

            for (int j = 0; j < textLength; j++)
                parsedText[i] = encodeSymbol(parsedText[i]);
        }

        return new String(parsedText);
    }

    private Group getGroup(int denominator, int minimum) {
        if (denominator <= 0)
            throw new IllegalArgumentException("Message too large.");

        Date date = new Date();
        int groupNumber = Integer.parseInt(String.valueOf(date.getDate()) + String.valueOf(date.getMonth()+1)) % denominator;
        if(groupNumber < MIN ) {
            return getGroup(denominator - 1, minimum);
        }
        group = keys.getGroups().get(groupNumber - MIN);
        Log.e("Group", String.valueOf(groupNumber));
        Log.e("MINIMUM GROUP", String.valueOf(group.getLength()));
        if (group.getLength() >= minimum)
            return group;
        else
            return getGroup(denominator - 1, minimum);
    }

    private Group getNextGroup(int minimum) {
        int groupNumber = keys.getGroups().indexOf(this.group);
        for (int i = groupNumber + 1; i != groupNumber; i++) {
            if (i > MAX)
                i = MIN;
            Group nextGroup = keys.getGroups().get(i);
            if (nextGroup.getLength() >= minimum)
                return nextGroup;
        }

        throw new IllegalArgumentException("Message too large.");
    }

    private int getKey(Group group, long number) {
        if(group.getKeys().size() == 0){
            getNextGroup(textLength);
            getKey(group, number);
        }
        Date date = new Date();
        Log.e("NUMbER", String.valueOf(number));
        Log.e("KEYNUM ROW", String.valueOf(((Integer.parseInt(String.valueOf(date.getDate()) + String.valueOf(date.getYear()), 10)
                * number) % group.getKeys().size())));
        keyNumber = (int)( (Integer.parseInt(String.valueOf(date.getDate()) + String.valueOf(date.getYear()), 10) * number) % group.getKeys().size());

//        Log.e("KEYNUM", String.valueOf(keyNumber));
        return Integer.parseInt(group.getKeys().get(keyNumber), 2);
    }

    private int getNextKey(Group group) {
        keyNumber++;
        if (keyNumber >= group.getKeys().size())
            keyNumber = 0;

        return Integer.parseInt(group.getKeys().get(keyNumber),2);
    }

    private int getKeyLength(int key) {
        return (int) Integer.toBinaryString(key).length();
    }

    private short getPhase(long number) {
        Log.e("NUMBER", Long.toString(number));
        Date date = new Date();


        return (short) (Integer.parseInt(String.valueOf(date.getDate()) + (date.getMonth()+1) + date.getYear(), 10) * number % keyLength);
    }

//    private BigInteger getConsequence(int phase, int key, int length) {
//
//    }

    private char encodeSymbol(char symbol) {
        Log.e("PHASE", String.valueOf(phase));
        char encoded = (char) (symbol ^ phase);

        for (int i = 0; i < keyLength; i++)
            phase = (short)((phase << 1) + Integer.bitCount(phase & key) % 2);

        return encoded;
    }
}
