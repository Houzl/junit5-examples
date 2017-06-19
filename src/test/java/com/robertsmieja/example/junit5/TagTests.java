package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("example")
@Tag("tag")
public class TagTests {

    @Tag("fast")
    @Test
    void testMethod(){
        System.out.println("TagTests.testMethod() executed");
    }
}
