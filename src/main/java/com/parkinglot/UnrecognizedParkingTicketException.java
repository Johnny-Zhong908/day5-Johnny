package com.parkinglot;

public class UnrecognizedParkingTicketException extends RuntimeException{
    public UnrecognizedParkingTicketException(){
        super("Unrecogonized parking ticket");
    }
}
