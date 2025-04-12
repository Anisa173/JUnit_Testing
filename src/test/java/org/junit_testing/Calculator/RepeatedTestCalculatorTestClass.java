package org.junit_testing.Calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RepeatedTestCalculatorTestClass {
    private static Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
        System.out.println("SetUp method is calling before each test case execution...! ");
    }

    @AfterEach
    void tearDown() {
        calc = null;
        System.out.println("TearDown method is calling after each test case execution...! ");
    }

    @BeforeAll
    static void setUpBeforeClass() {
        calc = new Calculator();
        System.out.println("SetUpBeforeClass method is calling before ALL test case execution...! ");
    }

    @AfterAll
    static void tearDownAfterClass() {
        calc = null;
        System.out.println("TearDownAfterClass method is calling after ALL test case execution...! ");
    }

    @RepeatedTest(value = 6 , name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("addNumbers is an adding operation...")
    @Order(1)
    void addNumbers() {
        assertEquals(30, calc.addNumbers(10, 20));
        System.out.println("The addResult is as excepted...!");
    }

    @DisplayName("subtract is a reducing value operation...")
    @Order(2)
    @Test
    void subtract() {
        assertEquals(-10, calc.subtract(10, 20));
        System.out.println("The subtractResult is as excepted...!");
    }

    @DisplayName("multiply is a * operation...")
    @Order(3)
    @Test
    void multiply() {
        assertEquals(200, calc.multiply(10, 20));
        System.out.println("The multiplyResult is as excepted...!");
    }

    @DisplayName("divide is a division operation...")
    @Order(4)
    @Test
    void divide() {
        assertEquals(0.0, calc.divide(20, 40));
        System.out.println("The divideResult is as excepted...!");
    }
}