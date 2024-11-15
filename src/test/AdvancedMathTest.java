package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdvancedMathTest {

    AdvancedMath math = new AdvancedMath();

    @DataProvider(name = "rootBisectionDataProvider")
    public Object[][] rootBisectionDataProvider() {
        return new Object[][] {
            {1, 2, 0.01, 1.5},
            {2, 4, 0.01, 3.0},
            {3, 4, 0.01, 7.5},
            {4, 5, 0.04, 6.0}
        };
    }

    // This method corresponds to a bisection root-finding test
    @Test(dataProvider = "rootBisectionDataProvider", groups = "math")
    public void findRootBisectionTest(double a, double b, double tolerance, double expected) {
        Assert.assertEquals(math.findRootBisection(a, b, tolerance), expected, 0.01);
    }

    @DataProvider(name = "armstrongDataProvider")
    public Object[][] armstrongDataProvider() {
        return new Object[][] {
            {153, true},
            {370, true},
            {123, false},
            {150, true},
            {340, true},
            {345, false}
        };
    }

    // This method tests if a number is an Armstrong number
    @Test(dataProvider = "armstrongDataProvider", groups = "math")
    public void isArmstrongTest(int num, boolean expected) {
        Assert.assertEquals(math.isArmstrong(num), expected);
    }

    @DataProvider(name = "sumOfDigitsDataProvider")
    public Object[][] sumOfDigitsDataProvider() {
        return new Object[][] {
            {123, 6},
            {456, 15}
        };
    }

    // This method tests the sum of digits for a number
    @Test(dataProvider = "sumOfDigitsDataProvider", groups = "math")
    public void sumOfDigitsTest(int num, int expected) {
        Assert.assertEquals(math.sumOfDigits(num), expected);
    }
}
