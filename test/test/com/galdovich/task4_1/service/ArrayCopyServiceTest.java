package com.galdovich.task4_1.service;

import com.galdovich.task4_1.entity.CustomArray;
import com.galdovich.task4_1.exception.CustomException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCopyServiceTest {

    ArrayCopyService arrayCopyService;

    @BeforeTest
    public void setUp() {
        arrayCopyService = new ArrayCopyService();
    }

    @Test
    public void arrayCopyTestFirst(){
        try{
            int[] actual = new int[]{3, -23, 443, 3, 61};
            CustomArray customArray = new CustomArray(actual);
            int[] expected = arrayCopyService.arrayCopy(customArray);
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Null exception")
    public void arrayCopyTestExceptionTest() throws CustomException {
        arrayCopyService.arrayCopy(null);
    }

    @Test
    public void arrayCopyTestSecond(){
        try{
            CustomArray customArray = new CustomArray(5);
            int[] array = new int[]{34, 62, 1, 64, 78};
            boolean actual = arrayCopyService.arrayCopy(customArray, array);
            assertTrue(actual);
        }catch (CustomException e){fail();}
    }

    @Test
    public void arrayCopyTestSecondNegative(){
        try{
            CustomArray customArray = new CustomArray(6);
            int[] array = new int[]{34, 62, 1, 64, 78};
            boolean actual = arrayCopyService.arrayCopy(customArray, array);
            boolean expected = false;
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Null exception")
    public void arrayCopyTestSecondExceptionTest() throws CustomException {
        arrayCopyService.arrayCopy(null);
    }

}