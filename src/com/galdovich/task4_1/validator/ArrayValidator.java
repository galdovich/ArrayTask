package com.galdovich.task4_1.validator;

public class ArrayValidator {
    public final static int MIN_THREE_DIGIT_NUMBER = 100;
    public final static int MAX_THREE_DIGIT_NUMBER = 999;

    /**
     * Returns true if the array is sorted from smallest to largest.
     */
    public boolean validateIsSortedUp(int[] array) {
        if (array == null) {
            return false;
        }
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            if (array[i] >
                    array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the search number in the array limits.
     */
    public boolean validateBinarySearchNumber(int[] sortedArray, int searchNumber){
        return (searchNumber >= sortedArray[0] &&
                searchNumber <= sortedArray[sortedArray.length - 1]);
    }

    /**
     * Returns "true" if number consist of three digits.
     */
    public boolean isNumberThreeDigit(int number){
        number = Math.abs(number);
        return number >= MIN_THREE_DIGIT_NUMBER && number <= MAX_THREE_DIGIT_NUMBER;
    }
}
