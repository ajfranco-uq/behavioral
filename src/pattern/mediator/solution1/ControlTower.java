package pattern.mediator.solution1;

// ===============================
// Concrete Mediator
// ===============================

// La torre centraliza las reglas y decide qué operación puede realizarse.
public class ControlTower implements AirTrafficControl {

    private boolean runwayAvailable = true;

    @Override
    public void requestLanding(Airplane airplane) {
        System.out.println(airplane.getFlightNumber() + " requests landing.");

        if (runwayAvailable) {
            runwayAvailable = false;
            System.out.println("Landing approved for " + airplane.getFlightNumber());
            airplane.land();
        } else {
            System.out.println("Landing denied. Runway occupied. " + airplane.getFlightNumber() + " must wait.");
        }
    }

    @Override
    public void requestTakeOff(Airplane airplane) {

        System.out.println(airplane.getFlightNumber() + " requests takeoff.");

        if (runwayAvailable) {
            runwayAvailable = false;
            System.out.println("Takeoff approved for " + airplane.getFlightNumber());
            airplane.takeOff();
        } else {
            System.out.println("Takeoff denied. Runway occupied.");
        }
    }

    @Override
    public void notifyRunwayAvailable(Airplane airplane) {
        runwayAvailable = true;
        System.out.println(airplane.getFlightNumber() + " has released the runway.");
        System.out.println("Runway is now available.");
    }
}