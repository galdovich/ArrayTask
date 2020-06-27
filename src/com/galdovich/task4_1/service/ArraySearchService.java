package com.galdovich.task4_1.service;

import com.galdovich.task4_1.entity.CustomArray;
import com.galdovich.task4_1.exception.CustomException;
import com.galdovich.task4_1.validator.ArrayValidator;

public class ArraySearchService {
    private static final String MESSAGE = "Null exception";

    public int searchMaxValue(CustomArray array) throws CustomException {
        if (array == null || array.getLength() < 1) {
            throw new CustomException(MESSAGE);
        }
        int max = 0;
        int length = array.getLength();
        for (int i = 0; i < length; i++){
            if (array.getElement(i) > max){
                max = array.getElement(i);
            }
        }
        return max;
    }

    public int searchMinValue(CustomArray array) throws CustomException {
        if (array == null || array.getLength() < 1) {
            throw new CustomException(MESSAGE);
        }
        int length = array.getLength();
        int min = array.getElement(0);
        for (int i = 0; i < length; i++){
            if (array.getElement(i) < min){
                min = array.getElement(i);
            }
        }
        return min;
    }

    public int binarySearchNumber(CustomArray array, int number) throws CustomException {
        ArrayValidator arrayValidator = new ArrayValidator();
        ArrayCopyService arrayCopyService = new ArrayCopyService();
        int[] arrayCopy = arrayCopyService.arrayCopy(array);
        if (!arrayValidator.validateIsSortedUp(arrayCopy)){
            throw new CustomException("Array is not sorted");
        }
        if (!arrayValidator.validateBinarySearchNumber(arrayCopy, number)){
            return -1;
        }
        int left = 0;
        int right = arrayCopy.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arrayCopy[middle] == number) {
                return middle;
            }
            if (arrayCopy[middle] < number) {
                left = middle + 1;
            }
            if (arrayCopy[middle] > number) {
                right = middle - 1;
            }
        }
        return -1;
    }

    public int[] searchSimpleNumbers(CustomArray array) throws CustomException {
        if (array == null || array.getLength() < 1) {
            throw new CustomException(MESSAGE);
        }
        int length = array.getLength();
        int amountSimpleNumbers = countAmountSimpleNumbers(array);
        int[] simpleNumbers = new int[amountSimpleNumbers];
        int count = 0;
        for (int i = 0; i < length; i++){
            int number = array.getElement(i);
            if (isSimple(number)){
                simpleNumbers[count] = number;
                count++;
            }
        }
        return simpleNumbers;
    }

    public int[] searchFibonacciNumbers(CustomArray array) throws CustomException {
        if (array == null || array.getLength() < 1) {
            throw new CustomException("Array exception");
        }
        int size = 0;
        int length = array.getLength();
        for (int i = 0; i < length; i++) {
            if (isNumberFibonacci(array.getElement(i))) {
                size++;
            }
        }
        int[] fibonacciArray = new int[size];
        int currentIndex = 0;
        for (int i = 0; i < length; i++) {
            if (isNumberFibonacci(array.getElement(i))) {
                fibonacciArray[currentIndex] = array.getElement(i);
                currentIndex++;
            }
        }
        return fibonacciArray;
    }

    public int[] searchThreeDigitUniqueNumbers(CustomArray array)
            throws CustomException {
        if (array == null) {
            throw new CustomException(MESSAGE);
        }
        ArrayValidator arrayValidator = new ArrayValidator();
        int size = 0;
        int length = array.getLength();
        for (int i = 0; i < length; i++) {
            if (arrayValidator.isNumberThreeDigit(array.getElement(i))
                    && isThreeNumberUnique(array.getElement(i))) {
                size++;
            }
        }
        int[] threeDigitUniqueNumbers = new int[size];
        int currentIndex = 0;
        for (int i = 0; i < length; i++) {
            if (arrayValidator.isNumberThreeDigit(array.getElement(i))
                    && isThreeNumberUnique(array.getElement(i))) {
                threeDigitUniqueNumbers[currentIndex] = array.getElement(i);
                currentIndex++;
            }
        }
        return threeDigitUniqueNumbers;
    }

    /**
     * Returns "true" if the number is a Fibonacci number.
     */
    private boolean isNumberFibonacci(int number) {
        boolean result = false;
        int first = 0;
        int second = 1;
        int positiveNumber = Math.abs(number);
        while (second <= positiveNumber) {
            if (positiveNumber == first || positiveNumber == second) {
                result = true;
                break;
            }
            second += first;
            first += second;
        }
        if (number < 0 && positiveNumber == first && number != -1) {
            result = false;
        }
        return result;
    }

    /**
     * Returns "true" if number consist of three unique digits.
     */
    private boolean isThreeNumberUnique(int number) {
        ArrayValidator arrayValidator = new ArrayValidator();
        boolean flag = false;
        if (arrayValidator.isNumberThreeDigit(number)) {
            int firstDigit = number % 10;
            int secondDigit = (number / 10) % 10;
            int thirdDigit = (number / 100) % 10;
            flag = firstDigit != secondDigit &&
                    firstDigit != thirdDigit &&
                    secondDigit != thirdDigit;
        }
        return flag;
    }

    /**
     * Returns amount of simple numbers included in the array.
     */
    private int countAmountSimpleNumbers(CustomArray array){
        int count = 0;
        int length = array.getLength();
        for (int i = 0; i < length; i++){
            if (isSimple(array.getElement(i))){
                count++;
            }
        }
        return count;
    }

    /**
     * Returns "true" if  number is simple.
     */
    private boolean isSimple(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++){
            if (number % i == 0) {
                count++;
                if (count > 2){
                    return false;
                }
            }
        }
        return count == 2;
    }
}
