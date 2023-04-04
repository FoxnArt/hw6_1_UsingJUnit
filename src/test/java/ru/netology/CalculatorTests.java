package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class CalculatorTests {
    Calculator sut;

    @BeforeEach
    public void beforeEach() {
        sut = Calculator.instance.get();
    }

    @AfterEach
    public void afterEach() {
        sut = null;
    }

    @Test
    public void testPlus() {
        // given:
        int a = 1, b = 2, expected = 3;

        // when:
        var result = sut.plus.apply(a, b);

        // then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMinus() {
        // given:
        int a = 3, b = 2, expected = 1;

        // when:
        var result = sut.minus.apply(a, b);

        // then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMultiply() {
        // given:
        int a = 2, b = 3, expected = 6;

        // when:
        var result = sut.multiply.apply(a, b);

        // then:
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("devideSource")
    public void testDevide(int a, int b, int expected) {
        // when:
        var result = sut.devide.apply(a, b);

        // then:
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> devideSource() {
        // given
        return Stream.of(
                Arguments.of(10, 2, 5),
                Arguments.of(50, 5, 10),
                Arguments.of(100, 25, 4)
        );
    }

    @Test
    public void testDevideByZero() {
        // given:
        int a = 2, b = 0;
        Class<ArithmeticException> expected = ArithmeticException.class;

        // when:
         Executable executable = () -> sut.devide.apply(a, b);

        // then:
        Assertions.assertThrowsExactly(expected, executable);
    }

    @Test
    public void testDevideByNonZero() throws Throwable {
        // given:
        int a = 2, b = 1;

        // when:
        Executable executable = () -> sut.devide.apply(a, b);

        // then:
        Assertions.assertDoesNotThrow(executable);
    }
}
