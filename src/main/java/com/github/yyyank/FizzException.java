package com.github.yyyank;

public class FizzException extends RuntimeException implements AutoCloseable{
    @Override
    public void close() {
        System.out.println("fizz");
    }
}