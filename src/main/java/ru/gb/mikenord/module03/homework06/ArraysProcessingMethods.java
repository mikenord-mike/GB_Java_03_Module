package ru.gb.mikenord.module03.homework06;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysProcessingMethods {

    public int[] afterLastFourElementsToArray(int[] inArray) {
        int lastFourIndex = -1;
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] == 4) {
                lastFourIndex = i;
            }
        }

        if (lastFourIndex == -1) {
            throw new RuntimeException("Input array does not contain 4");
        }

        return Arrays.copyOfRange(inArray, lastFourIndex + 1, inArray.length);
    }

    public boolean oneOrFourNumberCheck(int[] inArray) {
        if (inArray == null || inArray.length == 0) {
            return false;
        }

        return IntStream.of(inArray).allMatch(x -> (x == 1 || x == 4)) &&
                IntStream.of(inArray)
                        .distinct()
                        .sum() == 5;
    }

}
