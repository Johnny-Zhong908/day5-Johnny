package com.parkinglot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    public Map<Ticket,Car> parkingRecords = new HashMap<>();
    public final int parkingSpace = 10;
    public int presentSpace=0;
    public int[]  position = {1,1,1,1,1,1,1,1,1,1};
    public  Ticket park(Car car,Integer parkPosition){
        if(parkPosition ==null ) {
            throw new NoAvailablePosition();
        }
        if (presentSpace<parkingSpace&&parkPosition<11&&parkPosition>0&&position[parkPosition]==1){
            presentSpace+=1;
            position[parkPosition] = 0;
            Ticket ticket = new Ticket(parkPosition);
            parkingRecords.put(ticket,car);
            return  ticket;
        }
        return null;
    }


    public Car fetch(Ticket ticket) {
        if (ticket.isUsed()) {
            throw new UnrecognizedParkingTicketException();
        }
        if (parkingRecords.get(ticket) == null) {
            throw new UnrecognizedParkingTicketException();
        }

        presentSpace -= 1;
        Car car = parkingRecords.get(ticket);
        position[ticket.position] = 1;
        parkingRecords.remove(ticket);
        ticket.markAsUsed();
        return car;
    }

    public Car wrongFetch(Ticket ticket,Car car){
        if(position[ticket.position]==1){
            if(fetch(ticket).equals(car)){
                return fetch(ticket);
            }
        }

        throw new UnrecognizedParkingTicketException();

    }

}
