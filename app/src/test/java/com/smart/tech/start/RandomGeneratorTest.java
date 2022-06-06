package com.smart.tech.start;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGeneratorTest {

    private RandomGenerator generator;

    private final int MAX_VALUE = 1000000;
    private final double SUFFICIENT_PERCENTAGE_OF_DRAWN_NUMBERS = 60.0;
    private final int ZERO = 0;

    @BeforeEach
    void setup(){
        generator = new RandomGenerator();
    }

    @Test
    void shouldReturnNumbersSmallerThanMaxValue(){
        for (int i =0; i<1000000; i++) {
            assertTrue(generator.generate(MAX_VALUE) < MAX_VALUE);
        }
    }

    @Test
    void shouldReturnNumbersBiggerThanZeroOrEqualToZero(){
        for (int i =0; i<1000000; i++) {
            assertTrue(generator.generate(MAX_VALUE) >= ZERO);
        }
    }

    @RepeatedTest(10)
    void shouldReturnBiggerPercentageOfDrawnNumbersThanSufficientValue(){
        int[] numbersAmounts = new int[MAX_VALUE];

        for (int i=0; i<MAX_VALUE; i++)
            numbersAmounts[generator.generate(MAX_VALUE)]++;

        IntStream stream = Arrays.stream(numbersAmounts);

        long amountOfRandomNumbers = stream.filter(value -> value >0).count();

        double ratioOfRandomNumbers = (double) amountOfRandomNumbers/MAX_VALUE *100;

        assertTrue(ratioOfRandomNumbers > SUFFICIENT_PERCENTAGE_OF_DRAWN_NUMBERS);
    }
}
