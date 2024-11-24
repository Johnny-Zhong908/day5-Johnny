package com.parkinglot;

import java.util.ArrayList;

public class ParkingBoy {
    ArrayList<ParkingLot> hasParkinglot =new ArrayList<>();
    public ParkingLot parkingLot;
    public void addParkinglot(){
        hasParkinglot.add(new ParkingLot());
    }

    public Ticket park(ParkingLot parkingLot,Car car,Integer position1){
        return  parkingLot.park(car,position1);
    }

    public Car fetch(ParkingLot parkingLot,Ticket ticket){
        return parkingLot.fetch(ticket);
    }

    public Ticket multiplicationPark(ArrayList<ParkingLot> hasParkinglots,Car car,Integer position1){
        ParkingLot presentParkingLOT = null;
        for (ParkingLot parkinglot : hasParkinglots) {
            if (parkinglot.presentSpace < parkinglot.parkingSpace) {
                presentParkingLOT = parkinglot;
                break;
            }
        }
        if(presentParkingLOT == null){
            throw new NoAvailablePosition();
        }
        return presentParkingLOT.park(car,position1);
    }
    public Car multiplicationFetch(ArrayList<ParkingLot> hasParkinglots,Ticket ticket){
        ParkingLot persentParkinglots =null;
        for (ParkingLot parkingLot1 : hasParkinglots){
            if(parkingLot1.parkingRecords.get(ticket)!=null){
                persentParkinglots = parkingLot1;
                break;
            }
        }
        if(persentParkinglots == null){
            throw new UnrecognizedParkingTicketException();
        }
        return  persentParkinglots.fetch(ticket);
    }

}
