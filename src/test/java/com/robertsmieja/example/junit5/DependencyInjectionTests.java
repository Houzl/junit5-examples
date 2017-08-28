package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DependencyInjectionTests {
    Calculator objectUnderTest;

    @BeforeEach
    void setup(TestInfo testInfo){
        printTestInfo(testInfo);
        objectUnderTest = new Calculator();
    }

    @Test
    @DisplayName("Simple addition")
    //Multiple dependencies can be injected
    void simpleAddition(TestInfo testInfo, TestReporter testReporter){
        printTestInfo(testInfo);
        assertEquals(2, objectUnderTest.add(1, 1));

        //TestReporter is intended as a replacement to STDOUT/STDERR
        testReporter.publishEntry("key", "value");
    }

    private void printTestInfo(TestInfo testInfo){
        System.out.println("Display Name: <" + testInfo.getDisplayName() + ">");
        System.out.println("Test Class: <" + testInfo.getTestClass().get() + ">");
        System.out.println("Test Method: <" + testInfo.getTestMethod().get() + ">");
    }
}
