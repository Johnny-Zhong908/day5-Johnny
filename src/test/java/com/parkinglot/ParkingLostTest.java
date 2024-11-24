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
        Ticket ticket = parkinglot.park(car, position);
        //Then
        assertEquals(ticket.position,position);
    }

    @Test
    void should_return_the_car_when_fetch_given_a_ticket_then_() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        int parkPosition = 1;
        //When
        Ticket ticket = parkingLot.park(car, parkPosition);
        //Then
        assertEquals(parkingLot.fetch(ticket), car);
    }

    @Test
    void should_twice_when_twiceFetch_given_twoTicket_then_twoCar() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        int position1 = 1;
        int position2 = 2;
        Ticket ticket1 = parkingLot.park(car1, position1);
        Ticket ticket2 = parkingLot.park(car2, position2);
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
        Ticket ticket1 = parkingLot.park(car1, position1);
        Ticket ticket2 = parkingLot.park(car2, position2);
        //Then
        UnrecognizedParkingTicketException exception1 =
                assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.wrongFetch(ticket2,car1));
        assertEquals("Unrecogonized parking ticket", exception1.getMessage());
        UnrecognizedParkingTicketException exception2 =
                assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.wrongFetch(ticket1,car2));
        assertEquals("Unrecogonized parking ticket", exception2.getMessage());
    }

    @Test
    void should__when__given__then_usedTest() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        int position1 = 1;
        //When
        Ticket ticket = parkingLot.park(car1, position1);
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
                assertThrows(NoAvailablePosition.class, () -> parkingLot.park(car1, position));
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
        Ticket trueTicket = parkingLot.park(car, position1);
        parkingLot.parkingRecords.put(trueTicket, car);
        UnrecognizedParkingTicketException exception =
                assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(ticket));
        assertEquals("Unrecogonized parking ticket", exception.getMessage());
    }

    @Test
    void should__when__given__then_ParkingBoyCase1() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        Integer position = 1;
        //When
        Ticket ticket = parkingBoy.park(parkingBoy.parkingLot, car, position);
        //Then
        assertNotNull(ticket);
    }

    @Test
    void should__when__given__then_ParkingBoyCase2() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        Integer position = 1;
        //When
        Ticket ticket = parkingBoy.park(parkingBoy.parkingLot, car, position);
        //Then
        assertEquals(car, parkingBoy.parkingLot.parkingRecords.get(ticket));
    }

    @Test
    void should__when__given__then_ParkingBoyCase3() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        Car car2 = new Car();
        Integer position1 = 1;
        Integer position2 = 2;
        //When
        Ticket ticket1 = parkingBoy.park(parkingBoy.parkingLot,car1,position1);
        Ticket ticket2 = parkingBoy.park(parkingBoy.parkingLot,car2,position2);
        //Then
        assertEquals(car1,parkingBoy.parkingLot.fetch(ticket1));
        assertEquals(car2,parkingBoy.parkingLot.fetch(ticket2));
    }
    @Test
    void should__when__given__then_ParkingBoyCase4(){
    //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        Car car2 = new Car();
        Integer position1 = 1;
        Integer position2 = 2;
    //When
        Ticket ticket1 = parkingBoy.park(parkingBoy.parkingLot,car1,position1);
        Ticket ticket2 = parkingBoy.park(parkingBoy.parkingLot,car1,position2);
    //Then
        UnrecognizedParkingTicketException exception1 =
                assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.wrongFetch(parkingBoy.parkingLot,ticket2,car1));
        assertEquals("Unrecogonized parking ticket", exception1.getMessage());
        UnrecognizedParkingTicketException exception2 =
                assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.wrongFetch(parkingBoy.parkingLot,ticket1,car2));
        assertEquals("Unrecogonized parking ticket", exception2.getMessage());
    }
    @Test
    void should__when__given__then_ParkingBoyCase5(){
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        Integer position = 1;
        //When
        Ticket ticket = parkingBoy.park(parkingBoy.parkingLot,car1,position);
        Car fetchCar = parkingBoy.fetch(parkingBoy.parkingLot,ticket);
        //Then
        UnrecognizedParkingTicketException exception =
                assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(parkingBoy.parkingLot,ticket));
        assertEquals("Unrecogonized parking ticket", exception.getMessage());

    }
    @Test
    void should__when__given__then_ParkingBoyCase6(){
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        //When
        //Then
        NoAvailablePosition exception =
                assertThrows(NoAvailablePosition.class, () -> parkingBoy.park(parkingBoy.parkingLot,car1, null));
        assertEquals("No available position", exception.getMessage());

    }
    @Test
    void should__when__given__then_StanDardParkingBoyCase1(){
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        Integer position = 1;
        parkingBoy.addParkinglot();
        parkingBoy.addParkinglot();
        //When
        Ticket ticket = parkingBoy.multiplicationPark(parkingBoy.hasParkinglot,car1,position);
        //Then
        assertEquals(ticket.position,position);
    }
    @Test
    void should__when__given__then_StanDardParkingBoyCase2(){
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        Integer position = 1;
        parkingBoy.addParkinglot();
        parkingBoy.addParkinglot();
        //When
        Ticket ticket = parkingBoy.multiplicationPark(parkingBoy.hasParkinglot,car1,position);
        //Then
        assertEquals(ticket.position,position);
        assertEquals(parkingBoy.count,1);
    }
    @Test
    void should_twice_when_twiceFetch_given_twoTicket_then_StanDardParkingBoyCase3() {
        //Given
       ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        Car car2 = new Car();
        int position1 = 1;
        int position2 = 2;
        parkingBoy.addParkinglot();
        parkingBoy.addParkinglot();
        parkingBoy.hasParkinglot.get(0).presentSpace=9;
        Ticket ticket1 = parkingBoy.multiplicationPark(parkingBoy.hasParkinglot,car1,position1);
        assertEquals(parkingBoy.count,1);
        Ticket ticket2 = parkingBoy.multiplicationPark(parkingBoy.hasParkinglot,car2,position2);
        assertEquals(parkingBoy.count,2);
        assertEquals(car1,parkingBoy.multiplicationFetch(parkingBoy.hasParkinglot,ticket1));
        assertEquals(car2,parkingBoy.multiplicationFetch(parkingBoy.hasParkinglot,ticket2));
    }
    @Test
    void should__when__given__then_SmartParkingBoyCase1(){
        //Given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        Car car1 = new Car();
        Integer position = 1;
        smartParkingBoy.addParkinglot();
        smartParkingBoy.addParkinglot();
        //When
        Ticket ticket = smartParkingBoy.multiplicationPark(smartParkingBoy.hasParkinglot,car1,position);
        //Then
        assertEquals(ticket.position,position);
    }
    @Test
    void should__when__given__then_SmartParkingBoyCase2(){
        //Given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        Car car1 = new Car();
        Integer position = 1;
        smartParkingBoy.addParkinglot();
        smartParkingBoy.addParkinglot();
        //When
        Ticket ticket = smartParkingBoy.multiplicationPark(smartParkingBoy.hasParkinglot,car1,position);
        //Then
        assertEquals(ticket.position,position);
        assertEquals(smartParkingBoy.count,1);
    }
    @Test
    void should_twice_when_twiceFetch_given_twoTicket_then_SmartParkingBoyCase3() {
        //Given
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        Car car1 = new Car();
        Car car2 = new Car();
        int position1 = 1;
        int position2 = 2;
        parkingBoy.addParkinglot();
        parkingBoy.addParkinglot();
        parkingBoy.hasParkinglot.get(0).presentSpace=6;
        parkingBoy.hasParkinglot.get(1).presentSpace=6;
        Ticket ticket1 = parkingBoy.multiplicationPark(parkingBoy.hasParkinglot,car1,position1);
        assertEquals(parkingBoy.count,1);
        Ticket ticket2 = parkingBoy.multiplicationPark(parkingBoy.hasParkinglot,car2,position2);
        assertEquals(parkingBoy.count,2);
        assertEquals(car1,parkingBoy.multiplicationFetch(parkingBoy.hasParkinglot,ticket1));
        assertEquals(car2,parkingBoy.multiplicationFetch(parkingBoy.hasParkinglot,ticket2));
    }
    @Test
    void should__when__given__then_SuperParkingBoycase1(){
        //Given
        SuperParkingBoy smartParkingBoy = new SuperParkingBoy();
        Car car1 = new Car();
        Integer position = 1;
        smartParkingBoy.addParkinglot();
        smartParkingBoy.addParkinglot();
        //When
        Ticket ticket = smartParkingBoy.multiplicationPark(smartParkingBoy.hasParkinglot,car1,position);
        //Then
        assertEquals(ticket.position,position);
    }
    @Test
    void should__when__given__then_SuperParkingBoycase2(){
        //Given
        SuperParkingBoy smartParkingBoy = new SuperParkingBoy();
        Car car1 = new Car();
        Integer position = 1;
        smartParkingBoy.addParkinglot();
        smartParkingBoy.addParkinglot();
        //When
        Ticket ticket = smartParkingBoy.multiplicationPark(smartParkingBoy.hasParkinglot,car1,position);
        //Then
        assertEquals(ticket.position,position);
        assertEquals(smartParkingBoy.count,1);
    }
    @Test
    void should__when__given__then_SuperParkingBoycase3(){
        //Given
        SuperParkingBoy parkingBoy = new SuperParkingBoy();
        Car car1 = new Car();
        Car car2 = new Car();
        int position1 = 1;
        int position2 = 2;
        parkingBoy.addParkinglot();
        parkingBoy.addParkinglot();
        parkingBoy.hasParkinglot.get(0).presentSpace=6;
        parkingBoy.hasParkinglot.get(1).presentSpace=6;
        Ticket ticket1 = parkingBoy.multiplicationPark(parkingBoy.hasParkinglot,car1,position1);
        assertEquals(parkingBoy.count,1);
        Ticket ticket2 = parkingBoy.multiplicationPark(parkingBoy.hasParkinglot,car2,position2);
        assertEquals(parkingBoy.count,2);
        assertEquals(car1,parkingBoy.multiplicationFetch(parkingBoy.hasParkinglot,ticket1));
        assertEquals(car2,parkingBoy.multiplicationFetch(parkingBoy.hasParkinglot,ticket2));
    }
}
