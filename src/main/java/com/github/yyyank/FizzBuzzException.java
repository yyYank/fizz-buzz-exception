package com.github.yyyank;

public class FizzBuzzException extends RuntimeException implements AutoCloseable{
    @Override
    public void close() {
        System.out.println("fizzbuzz");
    }
}