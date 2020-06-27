package com.galdovich.task4_1.validator;

public class ArrayFillValidator {
    private static final int MIN_VALUE = -500;
    private static final int MAX_VALUE = 500;

    public boolean validateRandomBorder(int inputMin, int inputMax) {
        if (inputMax < inputMin){
            return false;
        }
        return inputMin >= MIN_VALUE && inputMax <= MAX_VALUE;
    }

    public boolean validateNumber(int number) {
        return number >= MIN_VALUE && number < MAX_VALUE;
    }
}
