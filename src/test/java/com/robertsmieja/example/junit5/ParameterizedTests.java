package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTests {
    Calculator objectUnderTest;

    @BeforeEach
    void setupEachTime(){
        objectUnderTest = new Calculator();
    }

    @DisplayName("Testing symmetric session sharing")
    @ParameterizedTest(name = "Test with value {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void testAddWithValueSource(int a){
        assertEquals(a + a,objectUnderTest.add(a, a));
    }

    @DisplayName("Testing using a CSV list of params")
    @ParameterizedTest(name = "Test with values {0} + {1}")
    @CsvSource({"1, 2", "2, 2", "1, 3" })
    void testAddWithCsvSource(int a, int b){
        assertEquals(a + b,objectUnderTest.add(a, b));
    }

    @DisplayName("Testing using a MethodSource for params")
    @ParameterizedTest(name = "Test with values {0} + {1}")
    @MethodSource("integerStream")
    void testAddWithMethodSource(int a, int b){
        assertEquals(a + b,objectUnderTest.add(a, b));
    }

    //Must return Stream, Iterable, Iterator or array
    //Must be static and accept no-args
    static Stream<Arguments> integerStream(){ return Stream.of(Arguments.of(1, 1), Arguments.of(2, 2)); }
}
