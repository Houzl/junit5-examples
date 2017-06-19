package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicTests {
    Calculator objectUnderTest;

    @BeforeEach
    void setupThatWillNotRun(TestReporter testReporter) {
        testReporter.publishEntry("setup", "This will run before each @TestFactory method");
        objectUnderTest = new Calculator();
    }

    @TestFactory
    @DisplayName("Empty TestFactory")
    Stream<DynamicTest> emptyTestFactory() {
        return Stream.of();
    }

    @TestFactory
    @DisplayName("Simple TestFactory for addition")
    Stream<DynamicTest> simpleTestFactoryForAddition() {
        return Stream.of(
                DynamicTest.dynamicTest("first simple test", () -> {
                    assertEquals(2, objectUnderTest.add(1, 1));
                }),
                DynamicTest.dynamicTest("second simple test", () -> {
                    assertEquals(4, objectUnderTest.add(2, 2));
                })
        );
    }

    @TestFactory
    @DisplayName("TestFactory that mutates state")
    Stream<DynamicTest> testFactoryThatMutatesState() {
        return Stream.of(
                DynamicTest.dynamicTest("mutate state", () -> {
                    assertNotNull(objectUnderTest);
                    objectUnderTest = null;
                    assertNull(objectUnderTest);
                }),
                DynamicTest.dynamicTest("NPE expected due to previous test setting objectUnderTest to null", () -> {
                    assertThrows(NullPointerException.class, () -> objectUnderTest.add(1, 1));
                })
        );
    }
}
