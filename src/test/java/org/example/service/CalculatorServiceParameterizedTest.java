package org.example.service;

import org.example.exception.DivByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceParameterizedTest {
    private final CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> paramsForPlusTest() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(2, 1, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForPlusTest")
    public void plusTest(Integer num1, Integer num2, Number expected) {
        Number actual = calculatorService.plus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> paramsForMinusTest() {
        return Stream.of(
                Arguments.of(2, 2, 0),
                Arguments.of(2, 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForMinusTest")
    public void minusTest(Integer num1, Integer num2, Number expected) {
        Number actual = calculatorService.minus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> paramsForMultiplyTest() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(2, 1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiplyTest")
    public void multiplyTest(Integer num1, Integer num2, Number expected) {
        Number actual = calculatorService.multiply(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> paramsForDividePositiveTest() {
        return Stream.of(
                Arguments.of(2, 2, 1),
                Arguments.of(2, -1, -2)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForDividePositiveTest")
    public void dividePositiveTest(Integer num1, Integer num2, Number expected) {
        Number actual = calculatorService.divide(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> paramsForDivideNegativeTest() {
        return Stream.of(
                Arguments.of(2, 0),
                Arguments.of(-2, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForDivideNegativeTest")
    public void divideNegativeTest(Integer num1, Integer num2) {
        Assertions.assertThrows(DivByZeroException.class, ()->calculatorService.divide(num1, num2));
    }
}
