package org.junit_testing.Factorial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FactorialTest {
    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new Factorial();
        System.out.println("SetUp method is executed before each test method...");
    }

    @AfterEach
    void tearDown() {
        factorial = null;
        System.out.println("AfterEach is activated after each test method is executed...");
    }

    @Test
    protected void factorial() {
        //factorial = new Factorial(number);
        int actualFact = factorial.factorialNumber(6);
        assertEquals(720, actualFact);
    }
}