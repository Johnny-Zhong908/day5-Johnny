package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLostTest {
    @Test
    void should_return_ticket__when_park_given_a_car_then_(){
    //Given
    ParkingLostTest parkinglot = new ParkingLostTest();
    Car car = new Car();
    Ticket ticket = new Ticket();
    assertNotNull(ticket);
    //When

    //Then
    }
    @Test
    void should_return_the_car_when_fetch_given_a_ticket_then_(){
    //Given
    ParkingLot parkingLot = new ParkingLot();
    Car car = new Car();
    Ticket ticket = parkingLot.park(car);
    //When
    Car fetchCar = parkingLot.fetch(ticket);
    //Then
        assertEquals(car,fetchCar);
    }
    @Test
    void should__when__given__then_(){
    //Given
    ParkingLot parkingLot = new ParkingLot();
    Car car1 = new Car();
    Car car2 = new Car();
    Ticket ticket1 = parkingLot.park(car1);
    Ticket ticket2 = parkingLot.park(car2);

    //When


    //Then
        assertEquals(parkingLot.fetch(ticket1),car1);
        assertEquals(parkingLot.fetch(ticket2),car2);
    }




}
