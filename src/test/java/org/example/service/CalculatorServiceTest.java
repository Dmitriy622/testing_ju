package org.example.service;

import org.example.exception.DivByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest() {
        int num1 = 2;
        int num2 = 1;
        Number expected = 3;
        Number actual = calculatorService.plus(num1, num2);
        Assertions.assertEquals(expected, actual);

        num1 = 3;
        num2 = -1;
        expected = 2;
        actual = calculatorService.plus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void minusTest() {
        int num1 = 2;
        int num2 = 1;
        Number expected = 1;
        Number actual = calculatorService.minus(num1, num2);
        Assertions.assertEquals(expected, actual);

        num1 = 3;
        num2 = -1;
        expected = 4;
        actual = calculatorService.minus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void multiplyTest() {
        int num1 = 2;
        int num2 = 1;
        Number expected = 2;
        Number actual = calculatorService.multiply(num1, num2);
        Assertions.assertEquals(expected, actual);

        num1 = 3;
        num2 = -1;
        expected = -3;
        actual = calculatorService.multiply(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void dividePositiveTest() {
        int num1 = 2;
        int num2 = 1;
        Number expected = 2;
        Number actual = calculatorService.divide(num1, num2);
        Assertions.assertEquals(expected, actual);

        num1 = 3;
        num2 = -1;
        expected = -3;
        actual = calculatorService.divide(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void divideNegativeTest() {
        int num1 = 2;
        int num2 = 0;
        Assertions.assertThrows(DivByZeroException.class,()-> calculatorService.divide(num1, num2));
    }
}
