package com.galdovich.task4_1.service;

import com.galdovich.task4_1.entity.CustomArray;
import com.galdovich.task4_1.exception.CustomException;

public class ArraySortService {

    public int[] bubbleSort(CustomArray customArray) throws CustomException {
        if (customArray == null) {
            throw new CustomException("Null exception");
        }
        int[] newArray = customArray.getArray();
        int length = customArray.getLength();
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (newArray[j] > newArray[j + 1]) {
                    swap(newArray, j, j + 1);
                }
            }
        }
        return newArray;
    }

    public int[] selectionSort(CustomArray customArray) throws CustomException {
        if (customArray == null) {
            throw new CustomException("Null exception");
        }
        int[] newArray = customArray.getArray();
        int length = newArray.length;
        for (int i = 0; i < length - 1; i++){
            int minIndex = 0;
            for (int j = i+1; j < length; j++){
                if (newArray[j] < newArray[i]){
                    minIndex = j;
                    swap(newArray, minIndex, i);
                }
            }
        }
        return newArray;
    }

    public void insertionSort(CustomArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Null exception");
        }
        int length = array.getLength();
        for (int i = 1; i < length; i++) {
            int current = array.getElement(i);
            int j = i - 1;
            while (j >= 0 && current < array.getElement(j)) {
                array.setElement(j + 1, array.getElement(j));
                j--;
            }
            array.setElement(j + 1, current);
        }
    }

    private void swap(int[] array, int min, int i) {
        int temp = array[min];
        array[min] = array[i];
        array[i] = temp;
    }
}
