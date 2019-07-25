package com.bvblogic.examplearbvb.bean.coding;

import com.bvblogic.examplearbvb.db.domain.coding.File;
import com.bvblogic.examplearbvb.db.domain.coding.Group;

import java.time.LocalDate;


public class Coder {
    private static final int MAX = 34;
    private static final int MIN = 8;

    private File file;

    private int key;

    private int textLength;

    private int keyLength;

    private short phase;

    private int groupNumber;

    private int keyNumber;


    public Coder(File file) {
        this.file = file;
    }

    public String encode(String text) {
        Group group = getGroup(35, text.length() * Character.SIZE);
        char[] parsedText = text.toCharArray();
        textLength = parsedText.length;


        key = getKey(group, file.getNumber()); // 1st iteration
        keyLength = getKeyLength(key);

        phase = getPhase(file.getNumber());

        for (int i = 0; i < textLength; i++)
            parsedText[i] = encodeSymbol(parsedText[i]);


        for (int i = 0; i <= 3; i++) { // other iterations
            group = getNextGroup(textLength);
            key = getKey(group, file.getNumber());
            phase = (short) (phase << 1);

            for (int j = 0; j < textLength; j++)
                parsedText[i] = encodeSymbol(parsedText[i]);
        }

        return new String(parsedText);
    }

    private Group getGroup(int denominator, int minimum) {
        if (denominator <= 0)
            throw new IllegalArgumentException("Message too large.");

        LocalDate date = LocalDate.now();
        groupNumber = (date.getDayOfMonth() + date.getMonthValue()) % denominator;

        Group group = file.getGroups().get(groupNumber);
        if (group.getLength() >= minimum)
            return group;
        else
            return getGroup(denominator - 1, minimum);
    }

    private Group getNextGroup(int minimum) {
        for (int i = groupNumber + 1; i != groupNumber; i++) {
            if (i > MAX)
                i = MIN;

            Group nextGroup = file.getGroups().get(groupNumber);

            if (nextGroup.getLength() >= minimum)
                return nextGroup;
        }

        throw new IllegalArgumentException("Message too large.");
    }

    private int getKey(Group group, int number) {
        LocalDate date = LocalDate.now();

        keyNumber = Integer.parseInt(String.valueOf(date.getDayOfMonth()) + String.valueOf(date.getYear()), 10)
                * number % group.getKeys().size();
        return group.getKeys().get(keyNumber);
    }

    private int getNextKey(Group group) {
        keyNumber++;
        if (keyNumber >= group.getKeys().size())
            keyNumber = 0;

        return group.getKeys().get(keyNumber);
    }

    private int getKeyLength(int key) {
        return (int) Math.pow(2, Integer.toBinaryString(key).length());
    }

    private short getPhase(int number) {
        LocalDate date = LocalDate.now();

        return (short) (Integer.parseInt(String.valueOf(date.getDayOfMonth()) + date.getMonthValue() + date.getYear(), 10) * number % keyLength);
    }

//    private BigInteger getConsequence(int phase, int key, int length) {
//
//    }

    private char encodeSymbol(char symbol) {
        char encoded = (char) (symbol ^ phase);

        for (int i = 0; i < keyLength; i++)
            phase = (short) (phase << 1 + Integer.bitCount(phase & key) % 2);

        return encoded;
    }
}
