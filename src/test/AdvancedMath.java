package test;
public class AdvancedMath {
    public double findRootBisection(double a, double b, double tolerance) {
        return (a + b) / 2;
    }

    public boolean isArmstrong(int num) {
        int sum = 0, original = num, digits = String.valueOf(num).length();
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }
        return original == sum;
    }

    public int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
