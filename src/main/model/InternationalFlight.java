package main.model;

import java.util.Objects;

public class InternationalFlight extends Flight {

    private String departureCountry;

    public InternationalFlight(double ticketPrice, int passengersNumber, String destination, boolean layover, String departureCountry) {
        super(ticketPrice, passengersNumber, destination, layover);
        this.departureCountry = departureCountry;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    @Override
    public String toString() {
        return super.toString() + " This flight comes from " + departureCountry + ". This is an international flight. ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InternationalFlight that = (InternationalFlight) o;
        return Objects.equals(departureCountry, that.departureCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departureCountry);
    }
}
