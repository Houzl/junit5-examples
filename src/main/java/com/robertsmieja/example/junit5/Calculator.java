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

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int divisor){
        if (Integer.valueOf(0).equals(divisor)){
            throw new ArithmeticException("You can't divide by zero.");
        }

        return a / divisor;
    }

}