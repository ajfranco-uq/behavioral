package pattern.mediator.solution2;

import java.util.ArrayList;
import java.util.List;

// ===============================
// Concrete Mediator
// ===============================
class ControlTower implements AirTrafficControl {

    private final List<Airplane> airplanes;

    private Airplane activeAirplane;

    private String activeOperation;

    public ControlTower() {
        airplanes = new ArrayList<>();
        activeAirplane = null;
        activeOperation = null;
    }

    public void registerAirplane(Airplane airplane) {
        airplanes.add(airplane);

        System.out.println("Airplane " + airplane.getFlightNumber() + " registered successfully.");
    }

    private boolean isRegistered(Airplane airplane) {
        return airplanes.contains(airplane);
    }

    @Override
    public void requestLanding(Airplane airplane) {

        System.out.println("\n" + airplane.getFlightNumber() + " requests landing permission.");

        if (!isRegistered(airplane)) {
            System.out.println("Unknown airplane.");
            return;
        }

        if (airplane.isUsingRunway()) {
            System.out.println("This airplane is already using the runway.");
            return;
        }

        if (activeAirplane != null) {
            System.out.println("!!!!!!LANDING DENIED!!!!!!: Runway is occupied.");
            System.out.println("Active flight: " + activeAirplane.getFlightNumber());
            return;
        }

        authorizeOperation(airplane, "LANDING");
    }

    @Override
    public void requestTakeOff(Airplane airplane) {

        System.out.println("\n" + airplane.getFlightNumber() + " requests takeoff permission.");

        if (!isRegistered(airplane)) {
            System.out.println("Unknown airplane.");
            return;
        }

        if (airplane.isUsingRunway()) {
            System.out.println("This airplane is already using the runway.");
            return;
        }

        if (activeAirplane != null) {
            System.out.println("TAKEOFF DENIED: Runway is occupied.");
            System.out.println("Active flight: " + activeAirplane.getFlightNumber());
            return;
        }

        authorizeOperation(airplane, "TAKEOFF");
    }

    private void authorizeOperation(
            Airplane airplane,
            String operation) {

        activeAirplane = airplane;
        activeOperation = operation;

        airplane.setUsingRunway(true);

        System.out.println("\n=== AUTHORIZATION GRANTED ===");
        System.out.println("Flight: " + airplane.getFlightNumber());
        System.out.println("Airline: " + airplane.getAirline());
        System.out.println("Operation: " + operation);

        System.out.println("Runway cleared. Proceed.");
    }

    @Override
    public void completeOperation(Airplane airplane) {

        if (activeAirplane == null) {
            System.out.println("There is no active operation.");
            return;
        }

        if (activeAirplane != airplane) {
            System.out.println("DENIED: This airplane does not have authorization to release the runway.");
            return;
        }

        System.out.println("\n" + airplane.getFlightNumber() + " completed " + activeOperation + ".");

        airplane.setUsingRunway(false);

        activeAirplane = null;
        activeOperation = null;

        System.out.println("Runway released successfully.");

        System.out.println("Runway is now AVAILABLE.");
    }

    @Override
    public void showRunwayStatus() {

        System.out.println("\n=== RUNWAY STATUS ===");

        if (activeAirplane == null) {
            System.out.println("Runway: AVAILABLE");
        } else {
            System.out.println("Runway: OCCUPIED");

            System.out.println("Active flight: " + activeAirplane.getFlightNumber());

            System.out.println("Operation: " + activeOperation);
        }
    }

    public void showAirplanes() {

        System.out.println("\n=== REGISTERED AIRPLANES ===");

        for (Airplane airplane : airplanes) {

            String status = airplane.isUsingRunway()
                    ? "USING RUNWAY"
                    : "AVAILABLE";

            System.out.println(airplane.getFlightNumber() + " | " + airplane.getAirline() + " | " + status);
        }
    }

    public Airplane findAirplane(String flightNumber) {

        for (Airplane airplane : airplanes) {
            if (airplane.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return airplane;
            }
        }
        return null;
    }
}