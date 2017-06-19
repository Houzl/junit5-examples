/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package com.robertsmieja.example.junit5;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JUnit4Tests {
    Calculator objectUnderTest;

    @Before
    public void setup() {
        objectUnderTest = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(3, objectUnderTest.add(1, 2));
    }

    @Test
    public void testDivide() {
        assertEquals(1, objectUnderTest.divide(2, 2));
    }

    @Test
    @Ignore
    public void testIgnoredTest(){
        fail("This test should not run");
    }
}