package pattern.mediator.problem;

public class Main {

    public static void main(String[] args) {

        Airplane airplane1 = new Airplane("AV101");
        Airplane airplane2 = new Airplane("LA202");
        Airplane airplane3 = new Airplane("IB303");

        // Establish direct relationships
        airplane1.addOtherAirplane(airplane2);
        airplane1.addOtherAirplane(airplane3);

        airplane2.addOtherAirplane(airplane1);
        airplane2.addOtherAirplane(airplane3);

        airplane3.addOtherAirplane(airplane1);
        airplane3.addOtherAirplane(airplane2);

        // Simulate airport operations
        airplane1.requestLanding();
        airplane2.requestLanding();
        airplane1.completeOperation();
        airplane2.requestLanding();
        airplane3.requestTakeOff();

    }
}
