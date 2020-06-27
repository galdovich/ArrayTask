package com.galdovich.task4_1.service;

import com.galdovich.task4_1.entity.CustomArray;
import com.galdovich.task4_1.exception.CustomException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySortServiceTest {
    ArraySortService arraySortService;

    @BeforeTest
    public void setUp() {
        arraySortService = new ArraySortService();
    }

    @DataProvider(name = "dataForSort")
    @Test
    public Object[][] dataForSort() {
        int[] actual = new int[]{3, 54, 12, 7, 91, -4};
        int[] expected =  new int[]{-4, 3, 7, 12, 54, 91};
        return new Object[][]{
                {actual, expected}
        };
    }

    @Test(dataProvider = "dataForSort")
    public void bubbleSortTest (int[] input, int[] expected){
        try{
            CustomArray customArray = new CustomArray(input);
            int[] actual = arraySortService.bubbleSort(customArray);
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}

    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Null exception")
    public void bubbleSortTExceptionTest() throws CustomException {
        arraySortService.bubbleSort(null);
    }

    @Test(dataProvider = "dataForSort")
    public void selectionSortTest (int[] input, int[] expected){
        try{
            CustomArray customArray = new CustomArray(input);
            int[] actual = arraySortService.bubbleSort(customArray);
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Null exception")
    public void selectionSortExceptionTest() throws CustomException {
        arraySortService.selectionSort(null);
    }

    @Test(dataProvider = "dataForSort")
    public void insertionSortTest (int[] input, int[] expected){
        try{
            CustomArray customArray = new CustomArray(input);
            int[] actual = arraySortService.bubbleSort(customArray);
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Null exception")
    public void insertionSortExceptionTest() throws CustomException {
        arraySortService.insertionSort(null);
    }
}