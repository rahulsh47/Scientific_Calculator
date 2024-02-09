package ScientificCalculatorTest;

import ScientificCalculatorSource.ScientificCalculator_source;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ScientificCalculator_Test  {
    ScientificCalculator_source calculator;

    @BeforeMethod
    public void setUp(){
        calculator = new ScientificCalculator_source();
    }

    @DataProvider(name = "TestData")
    public Object[][] csvTestDataDataProvider1() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("TestData.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] value= line.split(",");
            double num1 = Double.parseDouble(value[0]);
            double num2= Double.parseDouble(value[1]);
            testData.add(new Object[]{num1,num2});
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
            String[] value= line.split(",");
            double num = Double.parseDouble(value[0]);
            testData.add(new Object[]{num});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }

    @DataProvider(name = "TestData3")
    public Object[][] csvTestDataDataProvider3() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("TestData3.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] value= line.split(",");
            double angle = Double.parseDouble(value[0]);
            testData.add(new Object[]{angle});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }

    @DataProvider(name = "Pow_Test")
    public Object[][] csvTestDataDataProvider4() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("Pow_Test.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] value= line.split(",");
            double base = Double.parseDouble(value[0]);
            int power = Integer.parseInt(value[1]);

            testData.add(new Object[]{base , power});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }

    @Test(priority = 1 , groups = "basicOperation" , dataProvider = "TestData")
    public void testAddition(double num1,double num2){
        double add = calculator.Addition(num1,num2);
        Assert.assertEquals(add,num1+num2,"Addition test failed");
    }

    @Test(priority = 2 , groups = "basicOperation" , dataProvider = "TestData")
    public void testSubtraction(double num1 , double num2){
        double subtract = calculator.Subtraction(num1 , num2);
        Assert.assertEquals(subtract,num1 - num2,"Subtraction Test Fails");
    }

    @Test(priority = 3 , groups = "basicOperation" , dataProvider = "TestData")
    public void testMultiplication(double num1 , double num2){
        double Multiply = calculator.Multiplication(num1 , num2);
        Assert.assertEquals(Multiply,num1 * num2,"Multiplication test Fails");
    }

    @Test(priority = 4 , groups = "basicOperations" , dataProvider = "TestData")
    public void testDivision(double numerator , double denomenator){
        double Division = calculator.Division(numerator , denomenator);
        Assert.assertEquals(Division,numerator / denomenator,"Division test Fails");
    }

    //invalidAddition
    @Test(priority = 5)
    public void testInvalidAddition(){
        try {
            calculator.invalidAddition("akj", "deg");
            Assert.fail("Invalid addition test failed. Expected NumberFormatException, but no exception was thrown.");
        } catch (NumberFormatException e) {
            Assert.assertTrue(e.getMessage().startsWith("For input string:"), "Invalid exception message for invalid addition.");
        }
    }
    //invalidDivision
    @Test(priority = 6)
    public void testInvalidDivision(){
        try {
            calculator.invalidDivision(2,0);
            Assert.fail("Invalid division test failed. Expected ArithmeticException, but no exception was thrown.");
        } catch (ArithmeticException e) {
            Assert.assertTrue(e.getMessage().contains("divided by zero"), "Invalid exception message for invalid division");
        }
    }

    @Test(priority = 7 , groups = "advancedOperation" ,dataProvider = "TestData2")
    public void testSquareRoot(double num){
        double SquareRoot = calculator.SquareRoot(num);
        Assert.assertEquals(SquareRoot,Math.sqrt(num),"SquareRoot test Fails");
    }

    @Test(priority = 8 , groups = "advancedOperation" , dataProvider = "Pow_Test")
    public void testPower(double base , double power){
        double Power = calculator.Power(base , power);
        Assert.assertEquals(Power,Math.pow(base,power),"Power Test Fails");
    }

//    @AfterTest
//    public void tearDown(){
//        System.out.println("Closing Test Execution");
//    }

    @Test(priority = 9 , groups = "advancedOperation" , dataProvider = "TestData3")
    public void testSinFunction(double angle){
        double sin = calculator.SinFunction(angle);
        Assert.assertEquals(sin,Math.sin(Math.toRadians(angle)),0.0001,"Sin Function test Fails");
    }

    @Test(priority = 10 , groups = "advancedOperation" , dataProvider = "TestData3")
    public void testCosFunction(double angle){
        double cos = calculator.CosFunction(angle);
        Assert.assertEquals(cos,Math.cos(Math.toRadians(angle)),0.05,"cos function test Fails");
    }

    @Test(priority = 11 , groups = "advancedOperation" , dataProvider = "TestData3")
    public void testTanFuction(double angle){
        double tan = calculator.TanFunction(angle);
        Assert.assertEquals(tan,Math.tan(Math.toRadians(angle)),0.05,"tan function test Fails");
    }
}
