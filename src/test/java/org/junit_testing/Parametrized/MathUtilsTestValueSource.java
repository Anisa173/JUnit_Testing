package org.junit_testing.Parametrized;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTestValueSource {
    private static MathUtils mathUtils;



    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
        System.out.println("SetUp method is executed before each test case...");
    }

    @BeforeAll
    static void setUpBeforeClass() {
        mathUtils = new MathUtils();
        System.out.println("SetUpBeforeClass method is executed ONCE before all test case...");
    }

    @AfterEach
    void tearDown() {
        mathUtils = null;
        System.out.println("AfterEach method is executed after each test case...");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        mathUtils = null;
        System.out.println("AfterAll method is executed ONCE after all test cases...");
    }


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void isEven(int number) {
        assertTrue(mathUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", " ", "JUnit", "Parametrized", "Test"})
    void valueSourceTest(String element) {
        assertNotNull(element);

    }


    @ParameterizedTest
    @EnumSource(value = Days.class, names = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"})
    void isWeekDay(Days days) {
        assertTrue(mathUtils.isWeekDay(days));
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void factorialTest(int number,int excepted){
        assertEquals(excepted,mathUtils.factorial(number));
    }

    public static Stream<Arguments> argumentsProvider() {
   return Stream.of(
   Arguments.arguments(0,1),
           Arguments.arguments(1,1),
           Arguments.arguments(2,2),
           Arguments.arguments(3,6),
           Arguments.arguments(4,24),
           Arguments.arguments(5,120),
           Arguments.arguments(6,720)
   );

    }

}