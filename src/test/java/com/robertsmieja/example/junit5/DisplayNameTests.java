package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Awesome test class that shows off DisplayNames")
public class DisplayNameTests {

    Calculator objectUnderTest;

    @BeforeEach
    @DisplayName("BeforeEach setup method")
    void setup(){
        objectUnderTest = new Calculator();
    }

    @Test
    @DisplayName("Simple addition test")
    void simpleAdditionTest(){
        assertEquals(2, objectUnderTest.add(1, 1));
    }

    @Test
    @Disabled
    @DisplayName("Disabled addition test")
    void disabledAdditionTest(){
        fail("This should be disabled");
    }

    @Test
    @DisplayName("Simple division test")
    void simpleDivisionTest(){
        assertEquals(1, objectUnderTest.divide(2, 2));
    }
}
