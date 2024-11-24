package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLostTest {
    @Test
    void should_return_ticket__when_park_given_a_car_then_() {
        //Given
        ParkingLot parkinglot = new ParkingLot();
        Car car = new Car();
        Integer position = 1;
        //When
        Ticket ticket = parkinglot.park(car,position);
        //Then
        assertNotNull(ticket);
    }

    @Test
    void should_return_the_car_when_fetch_given_a_ticket_then_() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        int parkPosition = 1;
        //When
        Ticket ticket = parkingLot.park(car,parkPosition);
        //Then
        assertEquals(parkingLot.fetch(ticket),car);
    }

    @Test
    void should_twice_when_twiceFetch_given_twoTicket_then_twoCar(){
       //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        int position1 = 1;
        int position2 = 2;
        Ticket ticket1 = parkingLot.park(car1,position1);
        Ticket ticket2 = parkingLot.park(car2,position2);
        //When
        //Then
        assertEquals(parkingLot.fetch(ticket1), car1);
        assertEquals(parkingLot.fetch(ticket2), car2);
    }
      

    @Test
    void should__when__given__then_wrongFetch() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        int position1 = 1;
        int position2 = 2;
        //When
        Ticket ticket1 = parkingLot.park(car1,position1);
        Ticket ticket2 = parkingLot.park(car2,position2);
        //Then
        assertNull(parkingLot.wrongFetch(ticket1, car2));
        assertNull(parkingLot.wrongFetch(ticket2, car1));
    }

    @Test
    void should__when__given__then_usedTest() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        int position1 = 1;
        //When
        Ticket ticket = parkingLot.park(car1,position1);
        Car fetchCar = parkingLot.fetch(ticket);
        //Then
        UnrecognizedParkingTicketException exception =
                assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(ticket));
        assertEquals("Unrecogonized parking ticket", exception.getMessage());
    }

    @Test
    void should__when__given__then_noAvailablePark() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Integer position = null;
        //When
        NoAvailablePosition exception =
                assertThrows(NoAvailablePosition.class,() -> parkingLot.park(car1,position));
        //Then
        assertEquals("No available position", exception.getMessage());
    }

    @Test
    void should__when__given__then_unrecognized() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = new Ticket();
        int position1 = 1;
        Ticket trueTicket = parkingLot.park(car,position1);
        parkingLot.parkingRecords.put(trueTicket, car);
        UnrecognizedParkingTicketException exception =
                assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(ticket));
        assertEquals("Unrecogonized parking ticket", exception.getMessage());
    }
    @Test
    void should__when__given__then_ParkingBoyCase1(){
    //Given
    ParkingBoy parkingBoy = new ParkingBoy();
    Car car = new Car();
    Integer position = 1;
    //When
        Ticket ticket = parkingBoy.park(parkingBoy.parkingLot,car,position);
    //Then
        assertNotNull(ticket);
    }

    @Test
    void should__when__given__then_ParkingBoyCase2(){
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        Integer position = 1;
        //When
        Ticket ticket = parkingBoy.park(parkingBoy.parkingLot,car,position);
        //Then
        assertEquals(car,parkingBoy.parkingLot.parkingRecords.get(ticket));
    }



}
