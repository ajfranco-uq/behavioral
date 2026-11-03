package pattern.state.solution2;

public class IdleState implements ATMState {

    @Override
    public void insertCard(ATM atm) {

        System.out.println("Card inserted successfully.");
        System.out.println("Please enter your PIN.");

        atm.resetPinAttempts();
        atm.setState(new CardInsertedState());
    }

    @Override
    public void enterPin(ATM atm, String pin) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("No card inserted.");
    }
}
