package main.model;

import main.Discount;
import main.exceptions.CustomException;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private static Airport instance;
    public List<Flight> flights = new ArrayList<>();

    public static Airport getInstance() {
        if (instance == null) {
            instance = new Airport();
        }
        return instance;
    }

    private Airport() {
    }

    private void checkNumberOfFlights() {
        if (flights.size() >= 30) {
            throw new CustomException("Exceeding the max number of flights.");
        }
    }

    public void addDomesticFlight(double price, int passengersNumber, String destination, boolean layover) {
        checkNumberOfFlights();
        if (layover) {
            Discount discount = (double ticketPrice) -> (ticketPrice + (0.15 * ticketPrice));
            price = discount.discountCalculator(price);
        }
        DomesticFlight domesticFlight = new DomesticFlight(price, passengersNumber, destination, layover);
        flights.add(domesticFlight);
    }

    public void addInternationalFlight(double price, int passengersNumber, String destination, boolean layover, String departureCountry) {
        checkNumberOfFlights();
        Discount discount = (double ticketPrice) -> (ticketPrice - (0.1 * ticketPrice));
        price = discount.discountCalculator(price);
        InternationalFlight internationalFlight = new InternationalFlight(price, passengersNumber, destination, layover, departureCountry);
        flights.add(internationalFlight);
    }

    public String findFlightType(Flight searchedFlight) {
        for (Flight flight : flights) {
            if (flight.equals(searchedFlight)) {
                if (flight instanceof InternationalFlight) {
                    return "International Flight";
                }
                return "Domestic Flight";
            }
        }
        return "Couldn't find the flight";
    }

    public void printAllFlights() {
        for (Flight flight : flights) {
            System.out.println(flight.toString());
        }
    }

    public void printDomesticFlights() {
        for (Flight flight : flights) {
            if (flight instanceof DomesticFlight)
                System.out.println(flight.toString());
        }
    }

    public void printInternationalFlights() {
        for (Flight flight : flights) {
            if (flight instanceof InternationalFlight)
                System.out.println(flight.toString());
        }
    }

}
