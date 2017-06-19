package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class TimeoutAssertionTests {

    @Test
    @DisplayName("assertTimeout success with a void method")
    void assertTimeoutSuccessWithAVoidMethod() {
        assertTimeout(ofMillis(100), () -> {
        });
    }

    @Test
    @DisplayName("assertTimeout success with a return value")
    void assertTimeoutSuccessWithAReturnValue() {
        String result = assertTimeout(ofMillis(100), () -> threadWait(0));
        assertEquals("hello world", result);
    }

    @Test
    @DisplayName("assertTimeout failure")
    void assertTimeoutFailure() {
        assertTimeout(ofMillis(10), () -> threadWait(50));
    }

    @Test
    @DisplayName("assertTimeoutPreemptyively failure")
    void assertTimeoutPreemptivelyFailure() {
        //Similar to above but terminates test instead of waiting for thread to finish
        assertTimeoutPreemptively(ofMillis(10), () -> threadWait(50));
    }

    static String threadWait(int millisToSleep) throws InterruptedException {
        Thread.sleep(millisToSleep);
        return "hello world";
    }
}
