package main;

import main.model.Airport;
import main.model.Flight;

import java.util.Scanner;

public class Utils {

    public static void addDomesticFlight(Scanner scanner, Airport airport) {
        System.out.println("Add a price");
        double ticketPrice = scanner.nextDouble();

        System.out.println("Add number of passengers");
        int passengersNumber = scanner.nextInt();

        System.out.println("Add a destination");
        String destination = scanner.next();

        System.out.println("Does it have a layover?");
        String textLayover = scanner.next();
        boolean layover = textLayover.equals("yes");

        airport.addDomesticFlight(ticketPrice, passengersNumber, destination, layover);
    }

    public static void addInternationalFlight(Scanner scanner, Airport airport) {
        System.out.println("Add a price");
        double ticketPrice = scanner.nextDouble();

        System.out.println("Add number of passengers");
        int passengersNumber = scanner.nextInt();

        System.out.println("Add a destination");
        String destination = scanner.next();

        System.out.println("Does it have a layover?");
        String textLayover = scanner.next();
        boolean layover = textLayover.equals("yes");

        System.out.println("Add the departure country");
        String departureCountry = scanner.next();

        airport.addInternationalFlight(ticketPrice, passengersNumber, destination, layover, departureCountry);
    }

    public static void findFlight(Scanner scanner, Airport airport) {
        System.out.println("Specify the price");
        double ticketPrice = scanner.nextDouble();

        System.out.println("Specify the number of passengers");
        int passengersNumber = scanner.nextInt();

        System.out.println("Specify a destination");
        String destination = scanner.next();

        System.out.println("Specify if it has a layover?");
        String textLayover = scanner.next();
        boolean layover = textLayover.equals("yes");

        Flight flight = new Flight(ticketPrice, passengersNumber, destination, layover);

        System.out.println(airport.findFlightType(flight));
    }

}
