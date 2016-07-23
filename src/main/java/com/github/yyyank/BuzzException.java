package com.github.yyyank;

public class BuzzException extends RuntimeException implements AutoCloseable{
    @Override
    public void close() {
        System.out.println("buzz");
    }
}