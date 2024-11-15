package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GeometryTest {

    Geometry geometry = new Geometry();

    @DataProvider(name = "triangleAreaDataProvider")
    public Object[][] triangleAreaDataProvider() {
        return new Object[][] {
            {5, 10, 25},
            {7, 3, 10.5},
            {0, 10, 0}
        };
    }

    // Updated method name to match the TestNG XML
    @Test(dataProvider = "triangleAreaDataProvider", groups = "geometry")
    public void calculateTriangleAreaTest(double base, double height, double expected) {
        Assert.assertEquals(geometry.calculateTriangleArea(base, height), expected);
    }

    @DataProvider(name = "circleCircumferenceDataProvider")
    public Object[][] circleCircumferenceDataProvider() {
        return new Object[][] {
            {1, 6.2832},
            {5, 31.4159}
        };
    }

    // Updated method name to match the TestNG XML
    @Test(dataProvider = "circleCircumferenceDataProvider", groups = "geometry")
    public void circleCircumferenceTest(double radius, double expected) {
        Assert.assertEquals(geometry.circleCircumference(radius), expected, 0.0001);
    }
}
