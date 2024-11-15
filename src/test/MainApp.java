package test;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainApp extends JFrame {

    private final JTextArea resultArea;
    private final AdvancedCalculator calc;
    private final Geometry geometry;
    private final TextProcessor textProcessor;
    private final AdvancedMath math;

    public MainApp() {
        calc = new AdvancedCalculator();
        geometry = new Geometry();
        textProcessor = new TextProcessor();
        math = new AdvancedMath();

        setTitle("Utility Calculator");
        setSize(600, 600); // Adjusted the window size for more space
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Verdana", Font.PLAIN, 14));
        resultArea.setBackground(new Color(245, 245, 245));
        resultArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setPreferredSize(new Dimension(580, 300)); // Adjusted the scroll pane size
        add(scrollPane, BorderLayout.NORTH); // Positioned the result area to the top

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 2, 10, 10)); // Grid layout with 5 rows and 2 columns
        buttonPanel.setBackground(new Color(240, 240, 255));

        // Button with new layout and color scheme
        addButton(buttonPanel, "Find GCD", e -> {
            int a = getIntInput("Please enter the first integer for GCD calculation:", "GCD Calculation");
            int b = getIntInput("Please enter the second integer for GCD calculation:", "GCD Calculation");
            if (a != -1 && b != -1) {
                resultArea.append("GCD of " + a + " and " + b + ": " + calc.gcd(a, b) + "\n");
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });

        addButton(buttonPanel, "Fibonacci Sequence", e -> {
            int n = getIntInput("Please enter the position for Fibonacci sequence:", "Fibonacci Sequence");
            if (n != -1) {
                resultArea.append("Fibonacci number at position " + n + ": " + calc.fibonacci(n) + "\n");
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });

        addButton(buttonPanel, "Calculate Triangle Area", e -> {
            double base = getDoubleInput("Please enter the base of the triangle:", "Triangle Area Calculation");
            double height = getDoubleInput("Please enter the height of the triangle:", "Triangle Area Calculation");
            if (base != -1 && height != -1) {
                resultArea.append("Area of the triangle: " + geometry.calculateTriangleArea(base, height) + "\n");
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });

        addButton(buttonPanel, "Circle Perimeter", e -> {
            double radius = getDoubleInput("Please enter the radius of the circle:", "Circle Perimeter Calculation");
            if (radius != -1) {
                resultArea.append("Perimeter (Circumference) of the circle: " + geometry.circleCircumference(radius) + "\n");
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });

        addButton(buttonPanel, "Distance Between Coordinates", e -> {
            double x1 = getDoubleInput("Please enter the x1 coordinate:", "Distance Calculation");
            double y1 = getDoubleInput("Please enter the y1 coordinate:", "Distance Calculation");
            double x2 = getDoubleInput("Please enter the x2 coordinate:", "Distance Calculation");
            double y2 = getDoubleInput("Please enter the y2 coordinate:", "Distance Calculation");
            if (x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1) {
                resultArea.append("Distance between points: " + geometry.distanceBetweenPoints(x1, y1, x2, y2) + "\n");
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });

        addButton(buttonPanel, "Check Anagrams", e -> {
            String str1 = getStringInput("Please enter the first string:", "Anagram Check");
            String str2 = getStringInput("Please enter the second string:", "Anagram Check");
            if (str1 != null && str2 != null) {
                resultArea.append("Are the strings anagrams? " + textProcessor.areAnagrams(str1, str2) + "\n");
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });

        addButton(buttonPanel, "Reverse Sentence Words", e -> {
            String sentence = getStringInput("Please enter the sentence to reverse its words:", "Reverse Words");
            if (sentence != null) {
                resultArea.append("Reversed sentence: " + textProcessor.reverseWords(sentence) + "\n");
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });

        addButton(buttonPanel, "Find Root (Bisection)", e -> {
            double a = getDoubleInput("Please enter the starting range value:", "Root Bisection Method");
            double b = getDoubleInput("Please enter the ending range value:", "Root Bisection Method");
            double tolerance = getDoubleInput("Please enter the tolerance:", "Root Bisection Method");
            if (a != -1 && b != -1 && tolerance != -1) {
                resultArea.append("Root found using Bisection method: " + math.findRootBisection(a, b, tolerance) + "\n");
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });

        addButton(buttonPanel, "Check Armstrong Number", e -> {
            int num = getIntInput("Please enter a number to check if it's an Armstrong number:", "Armstrong Number Check");
            if (num != -1) {
                resultArea.append("Is this an Armstrong number? " + math.isArmstrong(num) + "\n");
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });

        addButton(buttonPanel, "Sum of Digits", e -> {
            int num = getIntInput("Please enter a number to calculate the sum of its digits:", "Sum of Digits");
            if (num != -1) {
                resultArea.append("Sum of digits: " + math.sumOfDigits(num) + "\n");
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });

        add(buttonPanel, BorderLayout.CENTER); // Positioned buttons in the center
    }

    private void addButton(JPanel panel, String title, ActionListener action) {
        JButton button = new JButton(title);
        button.setFont(new Font("Verdana", Font.PLAIN, 14));
        button.setBackground(new Color(144, 238, 144)); // Light green color for buttons
        button.setForeground(Color.WHITE); // Text color remains white
        button.setPreferredSize(new Dimension(220, 45));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.addActionListener(action);
        panel.add(button);
    }

    private int getIntInput(String message, String title) {
        try {
            String input = JOptionPane.showInputDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
            return input == null ? -1 : Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    private double getDoubleInput(String message, String title) {
        try {
            String input = JOptionPane.showInputDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
            return input == null ? -1 : Double.parseDouble(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    private String getStringInput(String message, String title) {
        String input = JOptionPane.showInputDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
        if (input == null || input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input cannot be empty! Please enter a valid string.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return input;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp app = new MainApp();
            app.setVisible(true);
        });
    }
}
