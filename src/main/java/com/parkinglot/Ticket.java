package com.parkinglot;

public class Ticket {
    public Integer position;
    boolean isUsed = false;
    public Ticket (){

    }
    public Ticket(Integer position){
        this.position = position;
    }

    public void markAsUsed() {
        this.isUsed = true;
    }
    public boolean isUsed() {
        return isUsed;
    }
}
