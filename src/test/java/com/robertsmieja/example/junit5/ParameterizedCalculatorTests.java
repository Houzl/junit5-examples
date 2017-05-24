package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedCalculatorTests {
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
    @MethodSource(names = {"integerStream"})
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void testAddWithMethodSource(int a, int b){
        assertEquals(a + b,objectUnderTest.add(a, b));
    }

    //Must return Stream, Iterable, Iterator or array
    //Must be static and accept no-args
    static Stream<Integer> integerStream(){ return  Stream.of(1, 2, 3); }
}
