package test.com.galdovich.task4_1.validator;

import com.galdovich.task4_1.validator.ArrayFillValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayFillValidatorTest {
    ArrayFillValidator arrayValidator;

    @BeforeTest
    public void setUp() {
        arrayValidator = new ArrayFillValidator();
    }

    @Test
    public void testValidateRandomBorderPositive() {
        boolean actual = arrayValidator.validateRandomBorder(0, 67);
        assertTrue(actual);
    }

    @Test
    public void testValidateRandomBorderNegative() {
        boolean actual = arrayValidator.validateRandomBorder(41, 24);
        assertFalse(actual);
    }

    @Test
    public void testValidateNumberPositive() {
        boolean actual = arrayValidator.validateRandomBorder(-241, 24);
        assertTrue(actual);
    }

    @Test
    public void testValidateNumberNegative() {
        boolean actual = arrayValidator.validateRandomBorder(-516, 24);
        assertFalse(actual);
    }

}