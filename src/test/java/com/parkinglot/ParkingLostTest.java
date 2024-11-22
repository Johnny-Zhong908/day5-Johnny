package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLostTest {
    @Test
    void should_return_ticket__when_park_given_a_car_then_() {
        //Given
        ParkingLostTest parkinglot = new ParkingLostTest();
        Car car = new Car();
        Ticket ticket = new Ticket();
        assertNotNull(ticket);
        //When

        //Then
    }

    @Test
    void should_return_the_car_when_fetch_given_a_ticket_then_() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //When
        Car fetchCar = parkingLot.fetch(ticket);
        //Then
        assertEquals(car, fetchCar);
    }

    @Test
    void should__when__given__then_() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        //When


        //Then
        assertEquals(parkingLot.fetch(ticket1), car1);
        assertEquals(parkingLot.fetch(ticket2), car2);
    }

    @Test
    void should__when__given__then_false() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        //When
        assertTrue(parkingLot.wrongFetch(ticket1,car2));
        assertTrue(parkingLot.wrongFetch(ticket2,car1));
        //Then
    }
    @Test
    void should__when__given__then_used(){
    //Given
    ParkingLot parkingLot = new ParkingLot();
    Car car1 =new Car();
    Ticket ticket = parkingLot.park(car1);
    Car fetch = parkingLot.fetch(ticket);
    assertNull(parkingLot.usedFetch(ticket));
    //When

    //Then
    }
    @Test
    void should__when__given__then_getPark(){
    //Given
    ParkingLot parkingLot = new ParkingLot();
    Car car1 = new Car();
    Ticket ticket = new Ticket();
    parkingLot.parkingRecords.put(ticket,car1);
    assertNull(parkingLot.getPark(car1,ticket));
    //When

    //Then
    }



}
