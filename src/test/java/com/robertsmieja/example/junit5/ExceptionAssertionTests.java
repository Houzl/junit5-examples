package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Exception assertion tests")
public class ExceptionAssertionTests {
    Calculator objectUnderTest;

    @BeforeEach
    void setup(){
        objectUnderTest = new Calculator();
    }

    @Test
    @DisplayName("Divide by zero throws exception")
    void divideByZeroThrowsExcepion() {
        //We can grab the exception from AssertThrows to perform more asserts
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> objectUnderTest.divide(0, 0));
        assertEquals("You can't divide by zero.", arithmeticException.getMessage());
    }

    @Test
    @DisplayName("Divide by zero throws exception with message coming from a Supplier")
    void divideByZeroThrowsExcepionWithSupplier() {
        //We can grab the exception from AssertThrows to perform more asserts
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> objectUnderTest.divide(0, 0));
        assertEquals("You can't divide by zero", arithmeticException.getMessage(), () -> "This test will intentionally fail because of a missing period.");
    }

}
