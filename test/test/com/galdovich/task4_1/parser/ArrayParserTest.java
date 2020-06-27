package test.com.galdovich.task4_1.parser;

import com.galdovich.task4_1.entity.CustomArray;
import com.galdovich.task4_1.exception.CustomException;
import com.galdovich.task4_1.parser.ArrayParser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayParserTest {
    ArrayParser arrayParser;

    @BeforeTest
    public void setUp() {
        arrayParser = new ArrayParser();
    }

    @DataProvider(name = "arrayParserData")
    public Object[][] createArrayParserData() {
        String[] firstInputArray = {"36", "-8", "16"};
        String[] secondInputArray = {"-4", "5", "42"};
        int[] firstParseNumbers = {36, -8, 16};
        int[] secondParseNumbers = {-4, 5, 42};
        return new Object[][]{{firstInputArray, firstParseNumbers},
                {secondInputArray, secondParseNumbers}};
    }

    @Test(dataProvider = "arrayParserData")
    public void parseToIntTest(String[] stringInput, int[] expected) {
        try {
            int[] actual =  arrayParser.parseToInt(stringInput);
            assertEquals(actual, expected);
        } catch (CustomException exc) {fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Parsing problem")
    public void parseToIntNegativeTest() throws CustomException {
        String[] stringArray = {"a", "32", "41"};
        arrayParser.parseToInt(stringArray);
    }
}
