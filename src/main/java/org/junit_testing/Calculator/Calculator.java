package org.junit_testing.Calculator;

public class Calculator {

    public int addNumbers(int a, int b) {
        int sum = 0;
        sum = a + b;
        return sum;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {

        if (b == 0) {
            throw new ArithmeticException("Division with zero is impossible!");
        } else {
            return a / b;
        }
    }

}

