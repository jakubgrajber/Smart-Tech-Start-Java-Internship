package com.smart.tech.start;

import java.util.Random;

//TODO
//Write unit-tests for this class
//that check its functionality and especially that the class returns random values
public class RandomGenerator {

    private final Random random = new Random();

    public int generate(int max) {
        return random.nextInt(max);
    }
}
