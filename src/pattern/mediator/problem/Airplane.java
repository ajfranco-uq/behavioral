package pattern.mediator.problem;

import java.util.ArrayList;
import java.util.List;

public class Airplane {

    private final String flightNumber;
    private final List<Airplane> otherAirplanes;

    private boolean usingRunway;

    public Airplane(String flightNumber) {
        this.flightNumber = flightNumber;
        this.otherAirplanes = new ArrayList<>();
        this.usingRunway = false;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public boolean isUsingRunway() {
        return usingRunway;
    }

    public void addOtherAirplane(Airplane airplane) {
        if (airplane != this && !otherAirplanes.contains(airplane)) {
            otherAirplanes.add(airplane);
        }
    }

    private boolean isRunwayOccupied() {
        for (Airplane airplane : otherAirplanes) {
            if (airplane.isUsingRunway()) {
                return true;
            }
        }
        return false;
    }

    public void requestLanding() {
        System.out.println("\n" + flightNumber + " requests landing.");

        if (usingRunway) {
            System.out.println("This airplane is already using the runway.");
            return;
        }

        if (isRunwayOccupied()) {
            System.out.println("LANDING DENIED: Another airplane is using the runway.");
            return;
        }

        usingRunway = true;
        System.out.println("LANDING APPROVED for " + flightNumber);
        System.out.println(flightNumber + " is landing.");
    }

    public void requestTakeOff() {
        System.out.println("\n" + flightNumber + " requests takeoff.");

        if (usingRunway) {
            System.out.println("This airplane is already using the runway.");
            return;
        }

        if (isRunwayOccupied()) {
            System.out.println("TAKEOFF DENIED: Another airplane is using the runway.");
            return;
        }

        usingRunway = true;
        System.out.println("TAKEOFF APPROVED for " + flightNumber);
        System.out.println(flightNumber + " is taking off.");
    }

    public void completeOperation() {
        if (!usingRunway) {
            System.out.println(flightNumber + " has no active operation.");
            return;
        }

        usingRunway = false;
        System.out.println(flightNumber + " completed its operation.");
        System.out.println("Runway released.");
    }
}
