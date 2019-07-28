package com.bvblogic.examplearbvb.bean.coding;

import android.util.Log;

import com.bvblogic.examplearbvb.bean.io.core.Group;
import com.bvblogic.examplearbvb.bean.io.core.Keys;

import java.util.Calendar;



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


    private String binary(String text){
        char[] messChar = text.toCharArray();
        String res = "";
        for (int i = 0; i < messChar.length; i++) {
            res += Integer.toBinaryString(messChar[i]) + " ";
        }
        return res;
    }
    public String encode(String text) {
        Log.e("TEXT Coder", text);

        Group group = getGroup(34, text.length() * Character.SIZE);
        char[] parsedText = text.toCharArray();
        textLength = parsedText.length;


        key = getKey(group, keys.getNumber()); // 1st iteration
        keyLength = getKeyLength(key);
        Log.e("KEY", Integer.toBinaryString(key));
        phase = getPhase(keys.getNumber());
        Log.e("PHASE", Integer.toBinaryString(phase));
        Log.e("KEYLENGTH", String.valueOf(keyLength));
        for (int i = 0; i < textLength; i++) {
            Log.e("Number of the symbol", String.valueOf(i));
            parsedText[i] = encodeSymbol(parsedText[i]);
        }

        for (int i = 0; i <= 3; i++) { // other iterations
            group = getNextGroup(textLength);
            key = getKey(group, keys.getNumber());
            phase = (short) (phase << 1);

            for (int j = 0; j < textLength; j++){
                Log.e("Number of the symbol 2", String.valueOf(i));
                parsedText[i] = encodeSymbol(parsedText[i]);
                if((text.length() == 7 || text.length() == 8) && i == 1){
                    parsedText[i] = encodeSymbol(parsedText[i]);
                }
            }
        }

        return new String(parsedText);
    }

    private Group getGroup(int denominator, int minimum) {
        if (denominator <= 0)
            throw new IllegalArgumentException("Message too large.");

//        Date date = new Date();
        Calendar date = Calendar.getInstance();
        int groupNumber = Integer.parseInt(String.valueOf(date.get(Calendar.DAY_OF_MONTH)) + String.valueOf(date.get(Calendar.MONTH)+1)) % denominator;
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
//        Date date = new Date();
        Calendar date = Calendar.getInstance();
        keyNumber = (int)( (Integer.parseInt(String.valueOf(date.get(Calendar.DAY_OF_MONTH)) + String.valueOf(date.get(Calendar.YEAR)), 10) * number) % group.getKeys().size());
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
        Log.e("NUMBER", Long.toBinaryString(number));
//        Date date = new Date();
        Calendar date = Calendar.getInstance();

        return (short) (Integer.parseInt(String.valueOf(date.get(Calendar.DAY_OF_MONTH)) + (date.get(Calendar.MONTH)+1) + date.get(Calendar.YEAR), 10) * number % keyLength);
    }

//    private BigInteger getConsequence(int phase, int key, int length) {
//
//    }

    private char encodeSymbol(char symbol) {
        Log.e("PHASE", Integer.toBinaryString(phase));
        char encoded = (char) (symbol ^ phase);

        for (int i = 0; i < keyLength; i++)
            phase = (short)((phase << 1) + Integer.bitCount(phase & key) % 2);

        return encoded;
    }
}
