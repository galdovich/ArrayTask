package test.com.galdovich.task4_1.validator;

import com.galdovich.task4_1.validator.ArrayValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayValidatorTest {
    ArrayValidator arrayValidator;

    @BeforeTest
    public void setUp() {
        arrayValidator = new ArrayValidator();
    }

    @Test
    public void testValidateIsSortedUpPositive() {
        int[] sorted = new int[]{3, 15, 43, 73, 77};
        boolean expected = arrayValidator.validateIsSortedUp(sorted);
        assertTrue(expected);
    }

    @Test
    public void testValidateIsSortedUpNegative() {
        int[] notSorted = new int[]{23, -5, 43, 73, 77};
        boolean expected = arrayValidator.validateIsSortedUp(notSorted);
        assertFalse(expected);
    }

    @Test
    public void testValidateBinarySearchNumberPositive() {
        int[] sorted = new int[]{3, 15, 43, 73, 77};
        boolean expected = arrayValidator.validateBinarySearchNumber(sorted, 46);
        assertTrue(expected);
    }

    @Test
    public void testValidateBinarySearchNumberNegative() {
        int[] sorted = new int[]{3, 15, 43, 73, 77};
        boolean expected = arrayValidator.validateBinarySearchNumber(sorted, 78);
        assertFalse(expected);
    }

    @Test
    public void testIsNumberThreeDigitPositive() {
        boolean actual = arrayValidator.isNumberThreeDigit(-233);
        assertTrue(actual);
    }

    @Test
    public void testIsNumberThreeDigitNegative() {
        boolean actual = arrayValidator.isNumberThreeDigit(23);
        assertFalse(actual);
    }
}