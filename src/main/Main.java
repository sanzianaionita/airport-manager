package main;

import main.model.Airport;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        Runnable drawRunnable = airport::printAllFlights;
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(drawRunnable, 0, 2, TimeUnit.MINUTES);
        Scanner scanner = new Scanner(System.in);

        String action;

        do {
            System.out.println("Type a specific action: " +
                    "Add domestic flight (DF), " +
                    "Add an international flight (IF), " +
                    "Find flight type (FT), " +
                    "Print all flights (F), " +
                    "Exit (exit).");
            action = scanner.next();
            switch (action) {
                case "DF":
                    Utils.addDomesticFlight(scanner, airport);
                    break;
                case "IF":
                    Utils.addInternationalFlight(scanner, airport);
                    break;
                case "FT":
                    Utils.findFlight(scanner, airport);
                    break;
                case "F":
                    airport.printAllFlights();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Wrong option");
            }
        } while (!action.equals("exit"));
    }

}
