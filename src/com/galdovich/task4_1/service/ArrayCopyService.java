package com.galdovich.task4_1.service;

import com.galdovich.task4_1.entity.CustomArray;
import com.galdovich.task4_1.exception.CustomException;

public class ArrayCopyService {

    /**
     * Returns an array int[] type, that is contained in CustomArray.
     */
    public int[] arrayCopy(CustomArray array) throws CustomException {
        if (array == null){
            throw new CustomException("Null exception");
        }
        int length = array.getLength();
        int[] arrayCopy = new int[length];
        for (int i = 0; i < length; i++){
            arrayCopy[i] = array.getElement(i);
        }
        return arrayCopy;
    }

    /**
     * The method copies the input array "newArray" to an array "CustomArray".
     *
     * @param array Array that takes input data
     * @param newArray Array that gives input data for "array"
     */
    public boolean arrayCopy(CustomArray array, int[] newArray) throws CustomException {
        if (array == null || newArray == null){
            throw new CustomException("Null exception");
        }
        if (array.getLength() != newArray.length){
            return false;
        }
        int length = array.getLength();
        for (int i = 0; i < length; i++){
            int value = newArray[i];
            array.setElement(i, value);
        }
        return true;
    }
}
