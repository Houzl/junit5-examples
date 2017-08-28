package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterfaceTests {
    @Tag("Inteface")
    @DisplayName("Example interface")
    public interface InterfaceWithTests {
        Calculator objectUnderTest = new Calculator();

        @Test
        default void simpleAdditionTest() {
            assertEquals(2, objectUnderTest.add(1, 1));
        }

        @Test
        default void simpleDivisionTest() {
            assertEquals(1, objectUnderTest.divide(2, 2));
        }
    }

    @DisplayName("Custom class")
    public static class ClassThatUsesInterfaceForTests implements InterfaceWithTests {
    }
}
