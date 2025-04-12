package org.junit_testing.Calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NestedCalculatorTest {
    private static Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
        System.out.println("SetUp method is executed before each test's method ...");
    }

    @AfterEach
    void tearDown() {
        cal = null;
        System.out.println("TearDown method is executed after each test's method ...");
    }

    @BeforeAll
    static void setUpBeforeClass() {
        cal = new Calculator();
        System.out.println("BeforeAll is executed once before all test cases...");
    }

    @AfterAll
    static void tearDownAfterClass() {
        cal = null;
        System.out.println("AfterAll is executed once after all test cases...!");

    }

    @DisplayName("+ operator of two numbers ")
    @Order(1)
    @Test
    void addNumbers() {
        assertEquals(11, cal.addNumbers(5, 6));
    }

    @DisplayName("- operator of two numbers ")
    @Order(2)
    @Test
    void subtract() {
        assertEquals(-1, cal.subtract(5, 6));
    }

    @DisplayName(" * operator of two numbers ")
    @Order(3)
    @Test
    void multiply() {
        assertEquals(30, cal.multiply(5, 6));
    }

    @DisplayName(" / operator of two numbers ")
    @Order(4)
    @Test
    void divide() {
        assertEquals(6, cal.divide(36, 6));
    }

    @Nested
    class AdditionsTests {

        @RepeatedTest(value = 2, name = RepeatedTest.LONG_DISPLAY_NAME)
        public void testAddPositiveNumbers() {
            assertEquals(10, cal.addNumbers(6, 4));
        }

        @Test
        public void testAddPositiveAndNegativeNumbers() {
            assertEquals(-2, cal.addNumbers(-6, 4));
        }

        @RepeatedTest(value = 2, name = RepeatedTest.LONG_DISPLAY_NAME)
        public void testAddOnlyNegativeNumbers() {
            assertEquals(-10, cal.addNumbers(-4, -6));
        }

        @Nested
        class MultiplyTest {
            @Test
            public void testMultiplyPositiveNumbers() {
                int actualResult = cal.multiply(4, 6);
                assertEquals(24, actualResult);
            }

            @Test
            public void testMultiplePositiveAndNegativeNumbers() {
                int desiredResult = cal.multiply(4, -6);
                assertEquals(-24, desiredResult);
            }

            @Test
            public void testMultiplyPositiveAndNegativeNumbers() {
                int actual = cal.multiply(-4, -6);
                assertEquals(24, actual);
            }

            @Nested
            class CriticalCases {
                @Disabled
                @Test
                public void testSubtractZero() {
                    assertNotEquals(1, cal.subtract(2, 0));
                }

                @Disabled
                @Test
                public void testSubtractWithSelf() {
                    assertNotEquals(1, cal.subtract(7, 7));
                }
            }

        }


    }


}