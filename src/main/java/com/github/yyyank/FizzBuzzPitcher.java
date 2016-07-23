package com.github.yyyank;

public class FizzBuzzPitcher {
    private FizzBuzzPitcher(){}
    public static void overThrow(int i) {
        boolean fizz = i != 0 && i % 3 == 0;
        boolean buzz = i != 0 && i % 5 == 0;
        boolean fizzBuzz = i != 0 && i % 15 == 0;
        if(fizzBuzz) {
            throw new FizzBuzzException();
        } else if(fizz) {
            throw new FizzException();
        } else if(buzz) {
            throw new BuzzException();
        } else {
            throw new SonomamaException(i);
        }
    }
}