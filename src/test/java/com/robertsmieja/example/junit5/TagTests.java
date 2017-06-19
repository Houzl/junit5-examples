package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

@Tag("tag")
@Tag("example")
public class TagTests {

    @Test
    @Tag("fast")
    void testAddition(){
        System.out.println("TagTests.testMethod() executed");
        assertEquals(3, new Calculator().add(1, 3));
    }
}
