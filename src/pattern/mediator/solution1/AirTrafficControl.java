package pattern.mediator.solution1;

// ===============================
// Mediator
// ===============================

//Esta interfaz define cómo los aviones pueden comunicarse con el mediador.
public interface AirTrafficControl {

    void requestLanding(Airplane airplane);

    void requestTakeOff(Airplane airplane);

    void notifyRunwayAvailable(Airplane airplane);
}