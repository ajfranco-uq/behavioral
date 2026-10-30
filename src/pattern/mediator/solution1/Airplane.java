package pattern.mediator.solution1;

// ===============================
// Colleague
// ===============================

// Airplane no conoce a los demás aviones. Solamente conoce a AirTrafficControl.
public class Airplane {

    private final String flightNumber;
    private final AirTrafficControl controlTower;

    public Airplane(String flightNumber, AirTrafficControl controlTower) {

        this.flightNumber = flightNumber;
        this.controlTower = controlTower;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void requestLanding() {
        controlTower.requestLanding(this);
    }

    public void requestTakeOff() {
        controlTower.requestTakeOff(this);
    }

    public void releaseRunway() {
        controlTower.notifyRunwayAvailable(this);
    }

    public void land() {
        System.out.println(flightNumber + " is landing.");
    }

    public void takeOff() {
        System.out.println(flightNumber + " is taking off.");
    }
}