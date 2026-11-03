package pattern.state.solution2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ATM atm = new ATM(
            "1234",
            1500.00,
            1000.00
        );

        int option = -1;

        while (option != 0) {

            System.out.println("\n===== ATM SYSTEM =====");
            System.out.println("1. Insert card");
            System.out.println("2. Enter PIN");
            System.out.println("3. Check balance");
            System.out.println("4. Withdraw money");
            System.out.println("5. Eject card");
            System.out.println("0. Exit");
            System.out.print("Select option: ");

            try {
                option = Integer.parseInt(
                    scanner.nextLine().trim()
                );

                switch (option) {
                    case 1 -> atm.insertCard();
                    case 2 -> {
                        System.out.print("Enter PIN: ");
                        String pin = scanner.nextLine();
                        atm.enterPin(pin);
                    }
                    case 3 -> atm.checkBalance();
                    case 4 -> {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = Double.parseDouble(scanner.nextLine().trim());
                        atm.withdraw(amount);
                    }
                    case 5 -> atm.ejectCard();
                    case 0 -> System.out.println("Goodbye!");
                    default -> System.out.println("Invalid menu option.");
                }

            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }

        scanner.close();
    }
}
