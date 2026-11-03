package pattern.state.solution2;

public class AuthenticatedState implements ATMState {

    @Override
    public void insertCard(ATM atm) {
        System.out.println("A card is already inserted.");
    }

    @Override
    public void enterPin(ATM atm, String pin) {
        System.out.println("You are already authenticated.");
    }

    @Override
    public void checkBalance(ATM atm) {

        System.out.printf("Your current balance is: $%.2f%n", atm.getBalance());
    }

    @Override
    public void withdraw(ATM atm, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount % 10 != 0) {
            System.out.println("Amount must be a multiple of 10.");
            return;
        }

        if (amount > atm.getBalance()) {
            System.out.println("Insufficient account balance.");
            return;
        }

        if (amount > atm.getCashAvailable()) {
            System.out.println("ATM has insufficient cash.");
            return;
        }

        atm.withdrawMoney(amount);

        System.out.printf("Please collect your cash: $%.2f%n", amount);

        System.out.printf("Remaining balance: $%.2f%n", atm.getBalance());
    }

    @Override
    public void ejectCard(ATM atm) {

        System.out.println("Transaction completed.");
        System.out.println("Card ejected successfully.");

        atm.setState(new IdleState());
    }
}
