package com.galdovich.task4_1.service;

import com.galdovich.task4_1.entity.CustomArray;
import com.galdovich.task4_1.exception.CustomException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.*;

public class ArrayCreateServiceTest {
    ArrayCreateService arrayCreateService;

    @BeforeTest
    public void setUp() {
        arrayCreateService = new ArrayCreateService();
    }

    @Test
    public void randomFillTest(){
        try{
            int[] array = new int[100];
            CustomArray customArray = new CustomArray(array);
            arrayCreateService.randomFill(customArray, 23, 143);
            int actualSize = customArray.getLength();
            int expectedSize = 100;
            assertEquals(actualSize, expectedSize);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "Incorrect border values")
    public void randomFillTestExceptionTest() throws CustomException {
        int[] array = new int[100];
        CustomArray customArray = new CustomArray(array);
        arrayCreateService.randomFill(customArray, 232, 143);
    }

    @Test
    public void testConsoleFillPositive() throws CustomException {
        int[] temp = new int[]{24, -56, 31};
        CustomArray customArray = new CustomArray(temp);
        String inputString = "24" + System.lineSeparator() +
                "-56" + System.lineSeparator() +
                "31" + System.lineSeparator();
        CustomArray expected = new CustomArray(3);
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in =
                new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        try {
            arrayCreateService.consoleFill(expected);
        } catch (CustomException e) {fail();}
        System.setIn(sysInBackup);
        assertEquals(expected, customArray);
    }

    @Test
    public void testConsoleFillNegative() throws CustomException {
        String inputString = "24" + System.lineSeparator() +
                "-56" + System.lineSeparator() +
                "31" + System.lineSeparator();
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in =
                new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        boolean actual = false;
        try {
            actual = arrayCreateService.consoleFill(null);
        } catch (CustomException e) {fail();}
        System.setIn(sysInBackup);
        assertFalse(actual);
    }

    @Test(expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "Incorrect input values")
    public void testConsoleFillException() throws CustomException {
        CustomArray array = new CustomArray(5);
        String data = "number" + System.lineSeparator();
        ByteArrayInputStream in =
                new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
        arrayCreateService.consoleFill(array);
    }

    @Test
    public void testFileFill() {
        try {
            int[] temp = new int[]{23, 42, 5, 6, 23, 7, -353};
            CustomArray customArray = new CustomArray(temp);
            CustomArray array = arrayCreateService.FileFill
                    ("resources\\ArrayResources.txt");
            assertEquals(array, customArray);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "Number is out of CustomArray range")
    public void testFileFillExceptionTest() throws CustomException{
        arrayCreateService.FileFill("resources\\ArrayResourcesTest.txt");
    }
}