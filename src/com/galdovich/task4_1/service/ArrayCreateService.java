package com.galdovich.task4_1.service;

import com.galdovich.task4_1.entity.CustomArray;
import com.galdovich.task4_1.exception.CustomException;
import com.galdovich.task4_1.parser.ArrayParser;
import com.galdovich.task4_1.reader.ArrayReader;
import com.galdovich.task4_1.validator.ArrayFillValidator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayCreateService {

    /**
     * Method that generates an array of random numbers.
     *
     * @param  max Maximum value of generate number in CustomArray
     * @param  min Minimum value of generate number in CustomArray
     */
    public boolean randomFill(CustomArray array, int min, int max) throws CustomException {
        ArrayFillValidator arrayFillValidator = new ArrayFillValidator();
        int length = array.getLength();
        if (!arrayFillValidator.validateRandomBorder(min, max)){
            throw new CustomException("Incorrect border values");
        }
        for (int i = 0; i < length; i++) {
            int randomValue = (int)(Math.random() * (max - min) + min);
            array.setElement(i, randomValue);
        }
        return true;
    }

    public boolean consoleFill(CustomArray array) throws CustomException{
        if (array == null) {
            return false;
        }
        ArrayCopyService arrayCopyService = new ArrayCopyService();
        int length = array.getLength();
        try{
            int[] consoleArray = getConsoleInput(length);
            arrayCopyService.arrayCopy(array, consoleArray);
        }catch (InputMismatchException exc){throw new CustomException("Incorrect input values");}
        return true;
    }

    private int[] getConsoleInput(int limit) throws InputMismatchException{
        int[] array = new int[limit];
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %d numbers: ", limit);
        for (int i = 0; i < limit; i++){
            int number = scanner.nextInt();
            array[i] = number;
        }
        return array;
    }

    public CustomArray FileFill(String file) throws CustomException{
        ArrayReader arrayReader = new ArrayReader();
        ArrayParser arrayParser = new ArrayParser();
        ArrayFillValidator fillValidator = new ArrayFillValidator();
        String[] stringArray = arrayReader.readFromFile(file);
        int[] array = arrayParser.parseToInt(stringArray);
        int length = array.length;
        CustomArray customArray = new CustomArray(length);
        for (int i = 0; i < length; i++){
            if (!fillValidator.validateNumber(array[i])){
                throw new CustomException("Number is out of CustomArray range");
            }
            customArray.setElement(i, array[i]);
        }
        return customArray;
    }
}
