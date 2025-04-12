package org.junit_testing.Calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeforeEachCalculatorTests {
    private static Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("setUp method calling before each test to be executed...");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("TearDown method is executed correctly after each test's cases...!");
    }

    @BeforeAll
    public static void setUpBeforeClass() {
        calculator = new Calculator();
        System.out.println("SetUpBeforeClass is being executed before all test's methods!");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        calculator = null;
        System.out.println(" TearDownAfterClass is being executed...! ");

    }

    @Order(1)
    @Test
    public void addTest() {
        int actualResult = calculator.addNumbers(7, 3);
        assertEquals(10, actualResult);
        System.out.println("The addResult is as expected!");
    }

    @Order(2)
    @Test
    public void subtractTest() {
        int actualResult = calculator.subtract(7, 3);
        assertEquals(4, actualResult);
        System.out.println(" The subtractResult is as expected...!");
    }

    @Order(3)
    @Test
    public void multiplyTest() {
        int actualResult = calculator.multiply(7, 3);
        assertEquals(21, actualResult);
        System.out.println(" The multiplyResult is as expected! ");
    }

    @Order(4)
    @Test
    public void divideTest() {
        int actualResult = calculator.divide(7, 3);
        assertEquals(2, actualResult);
        System.out.println("The divideResult is expected...!");
    }
}
