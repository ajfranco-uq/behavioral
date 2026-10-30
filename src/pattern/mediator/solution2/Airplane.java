package pattern.mediator.solution2;

// ===============================
// Colleague
// ===============================
class Airplane {

    private final String flightNumber;
    private final String airline;
    private final AirTrafficControl controlTower;

    private boolean usingRunway;

    public Airplane(String flightNumber, String airline, AirTrafficControl controlTower) {

        this.flightNumber = flightNumber;
        this.airline = airline;
        this.controlTower = controlTower;
        this.usingRunway = false;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public boolean isUsingRunway() {
        return usingRunway;
    }

    public void setUsingRunway(boolean usingRunway) {
        this.usingRunway = usingRunway;
    }

    // Delegate request to the mediator
    public void requestLanding() {
        controlTower.requestLanding(this);
    }

    public void requestTakeOff() {
        controlTower.requestTakeOff(this);
    }

    public void completeOperation() {
        controlTower.completeOperation(this);
    }
}