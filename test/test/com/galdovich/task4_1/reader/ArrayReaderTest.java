package test.com.galdovich.task4_1.reader;

import com.galdovich.task4_1.exception.CustomException;
import com.galdovich.task4_1.reader.ArrayReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayReaderTest {
    ArrayReader arrayReader;

    @BeforeTest
    public void setUp() {
        arrayReader = new ArrayReader();
    }

    @Test
    public void testReadFromFilePositive() {
        try {
            String[] actual = arrayReader.readFromFile("resources\\ArrayResources.txt");
            String[] expected = {"23", "42", "5", "6", "23", "7", "-353"};
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Reading problem")
    public void readFromFileExceptionTest() throws CustomException {
        arrayReader.readFromFile("resources\\Array.txt");
    }
}