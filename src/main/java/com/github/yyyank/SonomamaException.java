package com.github.yyyank;

public class SonomamaException extends RuntimeException implements AutoCloseable{

    private int value;
    public SonomamaException(int value){this.value = value;}

    @Override
    public void close(){
        System.out.println(value);
    }
}