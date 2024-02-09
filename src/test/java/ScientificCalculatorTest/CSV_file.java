package ScientificCalculatorTest;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV_file {
    @DataProvider(name = "TestData")
    public Object[][] csvTestDataDataProvider1() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("TestData.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String value= line;
            double num = Double.parseDouble(value);
            testData.add(new Object[]{num});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }
    @DataProvider(name = "TestData2")
    public Object[][] csvTestDataDataProvider2() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("TestData2.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String value= line;
            double num = Double.parseDouble(value);
            testData.add(new Object[]{num});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }
    @DataProvider(name = "csvTestData3")
    public Object[][] csvTestDataDataProvider3() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("TestData3.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String value= line;
            double num = Double.parseDouble(value);
            testData.add(new Object[]{num});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }

}
