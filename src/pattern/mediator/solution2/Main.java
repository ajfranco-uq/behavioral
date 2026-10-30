package pattern.mediator.solution2;

import java.util.Scanner;

// ===============================
// Application
// ===============================
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Create the mediator
        ControlTower controlTower = new ControlTower();

        // Create colleagues
        Airplane airplane1 = new Airplane("AV101", "Avianca", controlTower);
        Airplane airplane2 = new Airplane("LA202", "LATAM", controlTower);
        Airplane airplane3 = new Airplane("IB303", "Iberia", controlTower);

        // Register airplanes
        controlTower.registerAirplane(airplane1);
        controlTower.registerAirplane(airplane2);
        controlTower.registerAirplane(airplane3);

        int option;

        do {
            showMenu();
            option = readInteger("Select an option: ");
            System.out.println();

            switch (option) {
                case 1 -> controlTower.showAirplanes();
                case 2 -> requestLanding(controlTower);
                case 3 -> requestTakeOff(controlTower);
                case 4 -> completeOperation(controlTower);
                case 5 -> controlTower.showRunwayStatus();
                case 0 -> System.out.println("Closing Air Traffic Control System...");
                default -> System.out.println("Invalid option.");
            }

        } while (option != 0);

        scanner.close();
    }

    private static void showMenu() {

        System.out.println("\n==============================");
        System.out.println("   AIR TRAFFIC CONTROL SYSTEM");
        System.out.println("==============================");
        System.out.println("1. Show registered airplanes");
        System.out.println("2. Request landing");
        System.out.println("3. Request takeoff");
        System.out.println("4. Complete operation");
        System.out.println("5. Show runway status");
        System.out.println("0. Exit");
        System.out.println("==============================");
    }

    private static void requestLanding(ControlTower controlTower) {
        Airplane airplane = selectAirplane(controlTower);

        if (airplane != null) {
            airplane.requestLanding();
        }
    }

    private static void requestTakeOff(ControlTower controlTower) {
        Airplane airplane = selectAirplane(controlTower);

        if (airplane != null) {
            airplane.requestTakeOff();
        }
    }

    private static void completeOperation(ControlTower controlTower) {
        Airplane airplane = selectAirplane(controlTower);

        if (airplane != null) {
            airplane.completeOperation();
        }
    }

    private static Airplane selectAirplane(ControlTower controlTower) {

        System.out.print("Enter flight number: ");
        System.out.println();

        String flightNumber = scanner.nextLine().trim();

        Airplane airplane = controlTower.findAirplane(flightNumber);

        if (airplane == null) {
            System.out.println("Airplane not found.");
        }

        return airplane;
    }

    private static int readInteger(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
