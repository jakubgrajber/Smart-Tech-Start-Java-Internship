package com.smart.tech.start;

public class Calculator {

    public long plus(int x, int y) {
        return (long) x + y;
    }

    public long minus(int x, int y) {
        return (long) x - y;
    }

    public long multiple (int x, int y) {
        return (long) x*y;
    }

    public double divide (int x, int y) {
        if (y == 0){
            throw new IllegalArgumentException();
        }
        return (double) x/y;
    }

}
