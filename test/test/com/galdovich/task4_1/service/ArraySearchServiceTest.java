package com.galdovich.task4_1.service;

import com.galdovich.task4_1.entity.CustomArray;
import com.galdovich.task4_1.exception.CustomException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySearchServiceTest {

    ArraySearchService arraySearchService;

    @BeforeTest
    public void setUp() {
        arraySearchService = new ArraySearchService();
    }

    @Test
    public void searchMaxValueTest(){
        try{
            int[] array = new int[]{3, -23, 443, 3, 61};
            CustomArray customArray = new CustomArray(array);
            int actual = arraySearchService.searchMaxValue(customArray);
            int expected = 443;
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Null exception")
    public void searchMaxValueExceptionTest() throws CustomException {
        arraySearchService.searchMaxValue(null);
    }

    @Test
    public void searchMinValueTest(){
        try{
            int[] array = new int[]{3, -23, 443, 3, 61};
            CustomArray customArray = new CustomArray(array);
            int actual = arraySearchService.searchMinValue(customArray);
            int expected = -23;
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Null exception")
    public void searchMinValueExceptionTest() throws CustomException {
        arraySearchService.searchMinValue(null);
    }

    @Test
    public void binarySearchNumberTest(){
        try{
            int[] array = new int[]{3, 23, 43, 53, 61};
            CustomArray customArray = new CustomArray(array);
            int actual = arraySearchService.binarySearchNumber(customArray, 43);
            int expected = 2;
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Array is not sorted")
    public void binarySearchNumberExceptionTest() throws CustomException {
        int[] array = new int[]{3, 123, 43, 3, 61};
        CustomArray customArray = new CustomArray(array);
        arraySearchService.binarySearchNumber(customArray, 3);
    }

    @Test
    public void binarySearchNumberNegativeTest() throws CustomException {
        try{
            int[] array = new int[]{3, 23, 43, 53, 61};
            CustomArray customArray = new CustomArray(array);
            int actual = arraySearchService.binarySearchNumber(customArray, 76);
            int expected = -1;
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test
    public void searchSimpleNumbersTest(){
        try{
            int[] array = new int[]{3, 23, 43, 53, 61, 5, 15, 74, 1};
            CustomArray customArray = new CustomArray(array);
            int[] actual = arraySearchService.searchSimpleNumbers(customArray);
            int[] expected = new int[]{3, 23, 43, 53, 61, 5};
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Null exception")
    public void searchSimpleNumbersExceptionTest() throws CustomException {
        arraySearchService.searchSimpleNumbers(null);
    }

    @Test
    public void searchFibonacciNumbersTest(){
        try{
            int[] array = new int[]{3, 23, 43, 53, 61, 5, 15, 74, 1};
            CustomArray customArray = new CustomArray(array);
            int[] actual = arraySearchService.searchFibonacciNumbers(customArray);
            int[] expected = new int[]{3, 5, 1};
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Null exception")
    public void searchFibonacciNumbersExceptionTest() throws CustomException {
        arraySearchService.searchFibonacciNumbers(null);
    }

    @Test
    public void searchThreeDigitUniqueNumbersTest(){
        try{
            int[] array = new int[]{324, 231, 453, 533, 641, 514, 115, 234, 11};
            CustomArray customArray = new CustomArray(array);
            int[] actual = arraySearchService.searchThreeDigitUniqueNumbers(customArray);
            int[] expected = new int[]{324, 231, 453, 641, 514, 234};
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Null exception")
    public void searchThreeDigitUniqueNumbersExceptionTest() throws CustomException {
        arraySearchService.searchThreeDigitUniqueNumbers(null);
    }


}