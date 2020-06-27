package com.galdovich.task4_1.parser;

import com.galdovich.task4_1.exception.CustomException;

public class ArrayParser {

    public int[] parseToInt(String[] data) throws CustomException {
        int length = data.length;
        int[] array = new int[length];
        int counter = 0;
        try {
            for (String number : data) {
                array[counter++] = Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            throw new CustomException("Parsing problem");
        }
        return array;
    }
}
