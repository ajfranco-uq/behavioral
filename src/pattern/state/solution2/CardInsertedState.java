package pattern.state.solution2;

public class CardInsertedState implements ATMState {

    private static final int MAX_ATTEMPTS = 3;

    @Override
    public void insertCard(ATM atm) {
        System.out.println("A card is already inserted.");
    }

    @Override
    public void enterPin(ATM atm, String pin) {

        if (atm.validatePin(pin)) {

            System.out.println("Authentication successful.");

            atm.resetPinAttempts();
            atm.setState(new AuthenticatedState());

        } else {

            atm.incrementPinAttempts();

            int remaining = MAX_ATTEMPTS - atm.getPinAttempts();

            System.out.println("Incorrect PIN.");

            if (remaining > 0) {

                System.out.println("Remaining attempts: " + remaining);

            } else {

                System.out.println("Maximum attempts reached.");
                System.out.println("Card ejected for security.");

                atm.ejectCardPhysically();
                atm.resetPinAttempts();
                atm.setState(new IdleState());
            }
        }
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Please authenticate first.");
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        System.out.println("Please authenticate first.");
    }

    @Override
    public void ejectCard(ATM atm) {

        System.out.println("Card ejected.");

        atm.resetPinAttempts();
        atm.setState(new IdleState());
    }
}
