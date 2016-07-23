package com.github.yyyank;

public class FizzBuzzCatcher {
    private FizzBuzzCatcher(){}
    public static AutoCloseable make(int i) {
        try {
            FizzBuzzPitcher.overThrow(i);
        } catch(FizzException | BuzzException | FizzBuzzException | SonomamaException e) {
            return (AutoCloseable) e;
        }
        // unexpected state
        throw new IllegalStateException();
    }

    public static void receive(int i) throws Exception {
       try(AutoCloseable ex = make(i)){}
    }
}