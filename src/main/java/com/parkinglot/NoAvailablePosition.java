package com.parkinglot;

public class NoAvailablePosition extends RuntimeException{
    public NoAvailablePosition(){
        super("No available position");
    }
}
