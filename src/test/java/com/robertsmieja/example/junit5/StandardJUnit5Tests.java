package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

public class StandardJUnit5Tests {
    static int beforeAll, afterAll, beforeEach, afterEach = 0;

    @BeforeAll
    private static void oneTimeSetup() {
        ++beforeAll;
        System.out.println("BeforeAll has been run <" + beforeAll + "> time(s).");
    }

    @BeforeEach
    private void setup() {
        ++beforeEach;
        System.out.println("BeforeEach has been run <" + beforeEach + "> time(s).");
    }

    @AfterAll
    private static void oneTimeTeardown() {
        ++afterAll;
        System.out.println("AfterAll has been run <" + afterAll + "> time(s).");
    }

    @AfterEach
    private void teardown() {
        ++afterEach;
        System.out.println("AfterEach has been run <" + afterEach + "> time(s).");
    }

    @Test
    void passingTest(){
        System.out.println("passingTest() running...");
    }

    @Test
    void failingTest(){
        System.out.println("failingTest() running...");
        fail("This test will fail");
    }

    @Test
    @Disabled
    void ignoredTest(){
        fail("This test will not run");
    }
}
