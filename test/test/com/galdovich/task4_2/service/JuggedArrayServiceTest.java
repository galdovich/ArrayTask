package test.com.galdovich.task4_2.service;

import com.galdovich.task4_1.exception.CustomException;
import com.galdovich.task4_2.entity.SortType;
import com.galdovich.task4_2.service.JuggedArrayService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JuggedArrayServiceTest {
    JuggedArrayService juggedArrayService;

    @BeforeTest
    public void setUp() {
        juggedArrayService = new JuggedArrayService();
    }

    @DataProvider(name = "dataGeneralSorting")
    @Test
    public Object[][] dataGeneralSorting() {
        int[][] jArray = new int[4][];
        jArray[0] = new int[]{42,2,11};
        jArray[1] = new int[]{567};
        jArray[2] = new int[]{24,1,44,12,67,13};
        jArray[3] = new int[]{41,5,15,98,24};
        return new Object[][]{
                {jArray, SortType.MAX, false, expectedResult(SortType.MAX, false)},
                {jArray, SortType.MAX, true, expectedResult(SortType.MAX, true)},
                {jArray, SortType.MIN, false, expectedResult(SortType.MIN, false)},
                {jArray, SortType.MIN, true, expectedResult(SortType.MIN, true)},
                {jArray, SortType.SUM, false, expectedResult(SortType.SUM, false)},
                {jArray, SortType.SUM, true, expectedResult(SortType.SUM, true)}
        };
    }

    @Test (dataProvider = "dataGeneralSorting")
    public void testBubbleSort(int[][] array, SortType sortType,
                               boolean direction, int[][] expected) {
        try{
            juggedArrayService.bubbleSort(array, sortType, direction);
            boolean actual = jaggedArraysEquals(array, expected);
            assertTrue(actual);

        }catch (CustomException exc){fail();}

    }

    @Test(expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "Validate exception")
    public void bubbleSortExceptionTest() throws CustomException {
        juggedArrayService.bubbleSort(null, SortType.MAX, true);
    }

    private int[][] expectedResult(SortType sortType, boolean direction) {
        int[][] jArray3 = new int[3][];
        switch (sortType) {
            case MAX:
                if (direction == false) {
                    int[][] jArray = {{42, 2, 11}, {24, 1, 44, 12, 67, 13},
                            {41, 5, 15, 98, 24}, {567}};
                    return jArray;
                } else {
                    int[][] jArray = {{567}, {41, 5, 15, 98, 24},
                            {24, 1, 44, 12, 67, 13}, {42, 2, 11}};
                    return jArray;
                }
            case MIN:
                if (direction == false) {
                    int[][] jArray = {{24, 1, 44, 12, 67, 13}, {42, 2, 11},
                            {41, 5, 15, 98, 24}, {567}};
                    return jArray;
                } else {
                    int[][] jArray = {{567}, {41, 5, 15, 98, 24}, {42, 2, 11},
                            {24, 1, 44, 12, 67, 13}};
                    return jArray;
                }
            case SUM:
                if (direction == false) {
                    int[][] jArray = {{42, 2, 11}, {24, 1, 44, 12, 67, 13},
                            {41, 5, 15, 98, 24}, {567}};
                    return jArray;
                } else {
                    int[][] jArray = {{567}, {41, 5, 15, 98, 24},
                            {24, 1, 44, 12, 67, 13}, {42, 2, 11}};
                    return jArray;
                }
            default:
                return jArray3;
        }
    }

    private boolean jaggedArraysEquals(int[][] jArray1, int[][] jArray2) {
        for (int i = 0; i < jArray1.length; i++) {
            if (jArray1[i].length != jArray2[i].length) {
                return false;
            }
            for (int j = 0; j < jArray1[i].length; j++) {
                if (jArray1[i][j] != jArray2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}