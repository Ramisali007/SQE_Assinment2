package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdvancedCalculatorTest {

    AdvancedCalculator calculator = new AdvancedCalculator();

    @DataProvider(name = "gcdDataProvider")
    public Object[][] gcdDataProvider() {
        return new Object[][] {
            { 48, 18, 6 },
            { 56, 98, 14 },
            { 101, 10, 1 },
            { 78, 18, 45 },
            { 46, 98, 67 },
            { 145, 10, 89 }
        };
    }

    @Test(dataProvider = "gcdDataProvider", groups = "math")
    public void gcdTest(int a, int b, int expected) {
        Assert.assertEquals(calculator.gcd(a, b), expected);
    }

    @DataProvider(name = "fibonacciDataProvider")
    public Object[][] fibonacciDataProvider() {
        return new Object[][] {
            { 0, 0 },
            { 1, 1 },
            { 5, 5 },
            { 10, 55},
            { 1, 0 },
            { 1, 45 },
            { 54, 545 },
            { 101, 550}
        };
    }

    @Test(dataProvider = "fibonacciDataProvider", groups = "math")
    public void fibonacciTest(int n, int expected) {
        Assert.assertEquals(calculator.fibonacci(n), expected);
    }

    @Test(dataProvider = "gcdDataProvider", groups = "parameterized")
    public void gcdParameterizedTest(int a, int b, int expected) {
        Assert.assertEquals(calculator.gcd(a, b), expected);
    }

    @Test(dataProvider = "fibonacciDataProvider", groups = "parameterized")
    public void fibonacciParameterizedTest(int n, int expected) {
        Assert.assertEquals(calculator.fibonacci(n), expected);
    }
}
