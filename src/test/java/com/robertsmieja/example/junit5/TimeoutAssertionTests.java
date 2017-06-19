package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class TimeoutAssertionTests {

    @Test
    void assertTimeoutTest(){
        assertTimeout(ofMillis(10), () -> threadWait(50));
    }

    @Test
    void assertTimeoutPreemptivelyTest(){
        //Similar to above but terminates test instead of waiting for thread to finish
        assertTimeoutPreemptively(ofMillis(10), () -> threadWait(50));
    }

    static void threadWait(int millisToSleep) throws InterruptedException {
        Thread.sleep(millisToSleep);
    }
}
