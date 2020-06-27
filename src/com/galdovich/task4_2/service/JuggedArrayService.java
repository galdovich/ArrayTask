package com.galdovich.task4_2.service;

import com.galdovich.task4_1.exception.CustomException;
import com.galdovich.task4_2.entity.SortType;

public class JuggedArrayService {

    public void bubbleSort(int[][] array, SortType sortType, boolean direction) throws CustomException {
        if (array == null || sortType == null) {
            throw new CustomException("Validate exception");
        }
        boolean check = true;
        int length = array.length;
        while (check) {
            check = false;
            for (int i = 0; i < (length - 1); i++) {
                if (search(array[i], sortType) >
                        search(array[i+1], sortType)) {
                    swapLines(array, i, i + 1);
                    check = true;
                }
            }

        }
        if (direction) {
            reverseLines(array);
        }
    }

    private void swapLines(int[][] numbers, int firstIndex, int secondIndex) {
        int[] temp = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temp;
    }

    private int search(int[] array, SortType sortType) throws CustomException{
        int length = array.length;
        switch (sortType) {
            case MAX:
                int maxValue = 0;
                for (int i = 0; i < length; i++) {
                    if (maxValue < array[i]) {
                        maxValue = array[i];
                    }
                }
                return maxValue;
            case MIN:
                int minValue = array[0];
                for (int i = 0; i < length; i++) {
                    if (minValue > array[i]) {
                        minValue = array[i];
                    }
                }
                return minValue;
            case SUM:
                int sum = 0;
                for (int i = 0; i < length; i++) {
                    sum += array[i];
                }
                return sum;
            default:
                throw new CustomException("Null exception");
        }
    }

    private void reverseLines(int[][] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            swapLines(numbers, i, (numbers.length - 1) - i);
        }
    }
}


