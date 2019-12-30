package com.github.carloshh.fizzbuzz.domain;

public final class NumberClassified {
    private final int number;
    private final String value;

    public NumberClassified(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "EntryValue{" +
                "number=" + number +
                ", value='" + value + '\'' +
                '}';
    }
}
