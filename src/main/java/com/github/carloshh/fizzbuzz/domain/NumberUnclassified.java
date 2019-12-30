package com.github.carloshh.fizzbuzz.domain;

public final class NumberUnclassified {
    private final int number;

    public NumberUnclassified(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFizz() {
        return number % 3 == 0;
    }

    public boolean isBuzz() {
        return number % 5 == 0;
    }

    public boolean isFizzBuzz() {
        return isFizz() && isBuzz();
    }

    @Override
    public String toString() {
        return "Entry{" +
                "value=" + number +
                '}';
    }

}
