package org.junit_testing.Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void addNumbers() {
        int actualResult = calc.addNumbers(5, 8);
        assertEquals(13, actualResult);
        System.out.println("The result is as expected");
    }

    @Test
    void subtract() {
        assertEquals(3, calc.subtract(8, 5));
        System.out.println("The result is as expected!");
    }

    @Test
    void multiply() {
        assertEquals(42, calc.multiply(6, 7));
        System.out.println("The result is as expected!");
    }

    @Test
    void divide() {
    assertNotEquals(3,calc.divide(12,2), "The result is as expected!");

    }

}