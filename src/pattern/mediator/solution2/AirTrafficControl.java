package pattern.mediator.solution2;

// ===============================
// Mediator
// ===============================

interface AirTrafficControl {

    void requestLanding(Airplane airplane);

    void requestTakeOff(Airplane airplane);

    void completeOperation(Airplane airplane);

    void showRunwayStatus();
}