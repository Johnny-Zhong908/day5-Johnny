package com.parkinglot;

import java.util.ArrayList;

public class SmartParkingBoy {
    ArrayList<ParkingLot> hasParkinglot =new ArrayList<>();
    public void addParkinglot(ArrayList<ParkingLot> hasParkinglots){
        hasParkinglot.add(new ParkingLot());
    }
    public Ticket multiplicationPark(ArrayList<ParkingLot> hasParkinglot,Car car,Integer position1){
        ParkingLot presentParkingLOT = hasParkinglot.get(0);
        for (int i=1;i<hasParkinglot.size();i++) {
            if (presentParkingLOT.presentSpace <= hasParkinglot.get(i).presentSpace) {
                continue;
            }
            else {
                presentParkingLOT = hasParkinglot.get(i);
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
