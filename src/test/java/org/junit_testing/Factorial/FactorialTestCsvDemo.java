package org.junit_testing.Factorial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTestCsvDemo {
    private Factorial fact;

    @BeforeEach
    void setUp() {
        fact = new Factorial();
        System.out.println("SetUp Method is executed before each test case...");
    }

    @AfterEach
    void tearDown() {
        fact = null;
        System.out.println("TearDown Method is executed after each test case...");
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,1",
            "2,2",
            "3,6",
            "4,24",
            "5,120"
    })
    void factorialNumber(int number, int excepted) {
        assertEquals(excepted, fact.factorialNumber(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/factorial_data.csv")
    void factorialTestUsingCsvFileSource(int number, int excepted) {
        assertEquals(excepted, fact.factorialNumber(number));
    }

}