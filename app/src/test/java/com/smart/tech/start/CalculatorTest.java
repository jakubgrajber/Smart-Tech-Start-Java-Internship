package com.smart.tech.start;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator;

    private final int ZERO = 0;
    private final int VALUE_X = 7;
    private final int VALUE_Y = 6;
    private final int INT_MAX_VALUE = Integer.MAX_VALUE;
    private final int INT_MIN_VALUE = Integer.MIN_VALUE;
    private final long RESULT_OF_MULTIPLICATION_INT_MAX_VALUES = (long) INT_MAX_VALUE * INT_MAX_VALUE;
    private final int EXPECTED_XY_SUM = 13;
    private final int EXPECTED_XY_DIFF = 1;
    private final int EXPECTED_XY_PRODUCT = 42;
    private final double EXPECTED_XY_RATIO = 1.1666666666666667;
    private int ONE_VALUE = 1;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test that sum of two positive numbers is positive number")
    void plus_twoPositiveNumbers_resultIsPositive() {
        long sum = calculator.plus(VALUE_X, VALUE_Y);
        assertEquals(EXPECTED_XY_SUM, sum);
    }

    @Test
    @DisplayName("Test that sum of two big positive numbers is positive number")
    void plus_twoBigPositiveNumbers_resultIsPositive() {
        long sum = calculator.plus(INT_MAX_VALUE, INT_MAX_VALUE);
        assertTrue(sum > 0);
    }

    @Test
    void subtract_twoNumbers(){
        long result = calculator.minus(VALUE_X, VALUE_Y);
        assertEquals(EXPECTED_XY_DIFF, result);
    }

    @Test
    void subtract_fromBigNegativeNumber_resultIsNegative(){
        long result = calculator.minus(INT_MIN_VALUE, VALUE_X);
        assertTrue(result < 0);
    }

    @Test
    void multiple_twoNumbers(){
        long product = calculator.multiple(VALUE_X, VALUE_Y);
        assertEquals(EXPECTED_XY_PRODUCT, product);
    }

    @Test
    void multiple_twoBigPositiveNumbers_resultIsBiggerThanMultiplier() {
        long product = calculator.multiple(INT_MAX_VALUE, INT_MAX_VALUE);
        assertTrue(product > INT_MAX_VALUE);
    }

    @Test
    void multiple_intMaxValues(){
        long product = calculator.multiple(INT_MAX_VALUE, INT_MAX_VALUE);
        assertEquals(RESULT_OF_MULTIPLICATION_INT_MAX_VALUES, product);
    }

    @Test
    void divide_byZero_shouldThrowAnIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(VALUE_X, ZERO));
    }

    @Test
    void divide_TwoNumbers(){
        double ratio = calculator.divide(VALUE_X, VALUE_Y);
        assertEquals(EXPECTED_XY_RATIO, ratio);
    }

    @Test
    void divide_maxIntValueByMaxIntValue(){
        double ratio = calculator.divide(INT_MAX_VALUE, INT_MAX_VALUE);
        assertEquals(ONE_VALUE, ratio);
    }

}
