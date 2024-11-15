package test;

public class Geometry {
    public double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public double circleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public double distanceBetweenPoints(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
