/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package com.robertsmieja.example.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

@Tag("fast")
class CalculatorTests {

    Calculator objectUnderTest;
    @BeforeEach
    @DisplayName("Setup!")
    private void setupEachTime(){
        objectUnderTest = new Calculator();
    }

    @Test
    @DisplayName("My 1st JUnit 5 test! 😎")
    void myFirstTest(TestInfo testInfo) {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
        assertEquals("My 1st JUnit 5 test! 😎", testInfo.getDisplayName(), () -> "TestInfo is injected correctly");
    }

    @Test
    @DisplayName("Divide by zero throws exception")
    void divideByZeroThrowsExcepion() {
        //We can grab the exception from AssertThrows to perform more asserts
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> objectUnderTest.divide(0, 0));
        assertEquals("You can't divide by zero.", arithmeticException.getMessage());
    }

    @Test
    @DisplayName("Private methods still don't work, but will fail silenty")
    private void privateTestMethod(){
        throw new RuntimeException("This will never happen");
    }

}