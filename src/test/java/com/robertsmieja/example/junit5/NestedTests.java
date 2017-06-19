package com.robertsmieja.example.junit5;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("NestedCalculator tests")
public class NestedTests {
    Calculator objectUnderTest;

    @BeforeEach
    void setup(){
        objectUnderTest = new Calculator();
    }

    @Nested
    @DisplayName("Addition tests")
    class AdditionTests{
        @Test
        @DisplayName("Simple addition test")
        void simpleAddition(){
            assertEquals(2, objectUnderTest.add(1, 1));
        }
    }

    @Nested
    @DisplayName("Division tests")
    class DivisionTests {
        @Test
        @DisplayName("Simple division test")
        void simpleDivision(){
            assertEquals(1, objectUnderTest.divide(2, 2));
        }
    }

    @Nested
    @DisplayName("Failing tests")
    class FailingTests{
        @Test
        @DisplayName("Failing test")
        void failingTest(){
            fail("This is an intentional failure");
        }
    }

    @Nested
    @DisplayName("NullPointerException tests")
    class NullPointerExceptionTests{
        @BeforeEach
        void nestedTestSetup(){
            objectUnderTest = null;
        }

        @Test
        @DisplayName("NullPointerException test")
        void npeFailure(){
            assertEquals(2, objectUnderTest.add(1, 1));
        }
    }
}
