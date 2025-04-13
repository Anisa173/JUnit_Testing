package org.junit_testing.Factorial;

public class Factorial {

    public Integer factorialNumber(int number) {
        int factorial = 1;

        for (int i = 0; i <= number; i++) {
            factorial = factorial * i;

        }
    return factorial;

    }

}
