package ru.gb.mikenord.module03.homework06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


class TestArraysProcessingMethods {
    ArraysProcessingMethods methods = new ArraysProcessingMethods();

    @ParameterizedTest
    @MethodSource("testAfterLastFourElementsToArrayProvider")
    void parametrizedTestAfterLastFourElementsToArray(int[] inArray, int[] expectedArray) {
        Assertions.assertArrayEquals(expectedArray, methods.afterLastFourElementsToArray(inArray));
    }

    private static Stream<Arguments> testAfterLastFourElementsToArrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 4, 1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{3, 2, 4}, new int[]{})
        );
    }

    @Test
    void failTestAfterLastFourElementsToArray_NoFour() {
        Assertions.assertThrows(RuntimeException.class, () -> methods.afterLastFourElementsToArray(new int[]{3, 2}));
    }

    @Test
    void failTestAfterLastFourElementsToArray_EmptyArray() {
        Assertions.assertThrows(RuntimeException.class, () -> methods.afterLastFourElementsToArray(new int[]{}));
    }

    @ParameterizedTest
    @MethodSource("testOneOrFourNumberCheckProvider")
    void parametrizedTestOneOrFourNumberCheck(boolean expectedResult, int[] inArray) {
        Assertions.assertEquals(expectedResult, methods.oneOrFourNumberCheck(inArray));
    }

    private static Stream<Arguments> testOneOrFourNumberCheckProvider() {
        return Stream.of(
                Arguments.of( false, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(false, new int[]{1}),
                Arguments.of(false, new int[]{1, 1, 1, 1, 1}),
                Arguments.of(false, new int[]{}),
                Arguments.of(false, null),
                Arguments.of(true, new int[]{1, 4}),
                Arguments.of(true, new int[]{1, 1, 4, 4, 1})
        );
    }


}