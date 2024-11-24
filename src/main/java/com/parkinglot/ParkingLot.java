package com.parkinglot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    public Map<Ticket,Car> parkingRecords = new HashMap<>();
    public final Ticket usedTicket = new Ticket();
    public final int parkingSpace = 10;
    public int presentSpace=0;
    public int[]  position = {1,1,1,1,1,1,1,1,1,1};
    public  Ticket park(Car car,Integer parkPosition){
        if (presentSpace<parkingSpace&&parkPosition<11&&parkPosition>0&&position[parkPosition]==1){
            presentSpace+=1;
            position[parkPosition] = 0;
            Ticket ticket = new Ticket(parkPosition);
            parkingRecords.put(ticket,car);
            return  ticket;
        }
        if(parkPosition ==null ) {
            throw new NoAvailablePosition();
        }
        return null;

    }


    public  Car fetch(Ticket ticket) {
        if(ticket == usedTicket){
            throw new UnrecognizedParkingTicketException();
        }
        if (parkingRecords.get(ticket)==null){
            throw new UnrecognizedParkingTicketException();
        }else {
            presentSpace-=1;
            Car car = parkingRecords.get(ticket);
            position[ticket.position] = 1;
            ticket = usedTicket;
            parkingRecords.remove(ticket);
            return car;
        }

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
