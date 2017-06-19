package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

public class GroupedAssertionTests {
    Calculator objectUnderTest;

    @BeforeEach
    void setup(){
        objectUnderTest = new Calculator();
    }

    @Test
    @DisplayName("Group of addition tests")
    void groupOfAdditionTests(){
        assertAll("Grouped assertAll for addition",
                () -> assertEquals(2, objectUnderTest.add(1, 1)),
                () -> assertEquals(4, objectUnderTest.add(2, 2))
        );
    }

    @Test
    @DisplayName("Group of failures")
    //All passed statements will execute
    void groupOfFailures(){
        assertAll("Grouped assertAll failures",
                () -> fail("First failure"),
                () -> fail("Second failure")
        );
    }
}
