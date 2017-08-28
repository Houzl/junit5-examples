package com.robertsmieja.example.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(CustomDependencyInjectionTests.SimpleIntegerExtension.class)
public class CustomDependencyInjectionTests {
    Calculator objectUnderTest;

    @BeforeEach
    void setup(TestInfo testInfo){
        printTestInfo(testInfo);
        objectUnderTest = new Calculator();
    }

    @Test
    void simpleAdditionWithCustomDependencyInjected(TestInfo testInfo, Integer valueToAdd){
        printTestInfo(testInfo);
        assertEquals(4, objectUnderTest.add(valueToAdd, valueToAdd));
    }

    private void printTestInfo(TestInfo testInfo){
        System.out.println("Display Name: <" + testInfo.getDisplayName() + ">");
        System.out.println("Test Class: <" + testInfo.getTestClass().get() + ">");
        System.out.println("Test Method: <" + testInfo.getTestMethod().get() + ">");
    }

    public static class SimpleIntegerExtension implements ParameterResolver{
        @Override
        public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return parameterContext.getParameter().getType().equals(Integer.class);
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return Integer.valueOf(2);
        }
    }
}
