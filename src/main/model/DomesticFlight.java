package main.model;

public class DomesticFlight extends Flight{

    DomesticFlight (double ticketPrice, int passengersNumber, String destination, boolean layover){
        super(ticketPrice, passengersNumber, destination, layover);
    }

    @Override
    public String toString(){
        return super.toString() + " This is a domestic flight. ";
    }

}
