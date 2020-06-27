package com.galdovich.task4_1.entity;

import com.galdovich.task4_1.exception.CustomException;
import java.util.Arrays;

public class CustomArray {
    private static final int DEFAULT_SIZE = 10;
    final int[] customArray;

    public CustomArray(int[] inputArray) throws CustomException{
        if (inputArray == null) {
            throw new CustomException("Array exception");
        }
        this.customArray = new int[inputArray.length];
        copy(inputArray);
    }

    private void copy(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            this.customArray[i] = inputArray[i];
        }
    }

    public CustomArray(int arraySize){
        if (arraySize < 0){
            arraySize = DEFAULT_SIZE;
        }
        this.customArray = new int[arraySize];
    }

    public boolean setElement(int index, int value) {
        if (customArray.length <= index || index < 0){
            return false;
        }else {
            customArray[index] = value;
            return true;
        }
    }

    public int getElement(int index){
        return customArray[index];
    }

    public int getLength() {
        return customArray.length;
    }

    public int[] getArray() {
        return customArray;
    }

    private boolean equalsTo(CustomArray array) {
        if (customArray.length != array.getLength()) {
            return false;
        }
        for (int i = 0; i < customArray.length; i++) {
            if (customArray[i] != array.getElement(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray customArray = (CustomArray) o;
        return equalsTo(customArray);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        for (int i = 0; i < customArray.length; i++) {
            result = prime * customArray[i] + result;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("customArray=").append(Arrays.toString(customArray));
        sb.append('}');
        return sb.toString();
    }
}
