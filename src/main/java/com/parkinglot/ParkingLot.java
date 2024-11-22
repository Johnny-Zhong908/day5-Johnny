package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    public Map<Ticket,Car> parkingRecords = new HashMap<>();
    private final Ticket usedTicket = new Ticket();
    public  Ticket park(Car car){
        Ticket ticket = new Ticket();
        parkingRecords.put(ticket,car);
        return  ticket;
    }
    public Car getPark(Car c1,Ticket ticket){
        if(c1.equals(parkingRecords.get(ticket))){
            return null;
        }
        return c1;
    }
    public  Car fetch(Ticket ticket){
        return parkingRecords.get(ticket);
    }
    public Boolean wrongFetch(Ticket ticket,Car car){
        return !fetch(ticket).equals(car);
    }
    public Ticket usedFetch(Ticket ticket){
        return null;
    }
}
