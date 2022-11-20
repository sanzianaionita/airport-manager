package main.model;

import java.util.Objects;

public class Flight {

    private double ticketPrice;
    private int passengersNumber;
    private String destination;
    private boolean layover;

    public Flight(double ticketPrice, int passengersNumber, String destination, boolean layover) {
        this.ticketPrice = ticketPrice;
        this.passengersNumber = passengersNumber;
        this.destination = destination;
        this.layover = layover;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isLayover() {
        return layover;
    }

    public void setLayover(boolean layover) {
        this.layover = layover;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "ticketPrice=" + ticketPrice +
                ", passengersNumber=" + passengersNumber +
                ", destination='" + destination + '\'' +
                ", layover=" + layover +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Double.compare(flight.ticketPrice, ticketPrice) == 0 && passengersNumber == flight.passengersNumber && layover == flight.layover && destination.equals(flight.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketPrice, passengersNumber, destination, layover);
    }
}
