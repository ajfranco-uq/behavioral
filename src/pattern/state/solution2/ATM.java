package pattern.state.solution2;

public class ATM {

    private ATMState state;

    private final String correctPin;
    private double balance;
    private double cashAvailable;
    private int pinAttempts;

    public ATM(
            String correctPin,
            double initialBalance,
            double initialCash) {

        this.correctPin = correctPin;
        this.balance = initialBalance;
        this.cashAvailable = initialCash;

        this.state = new IdleState();
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public void insertCard() {
        state.insertCard(this);
    }

    public void enterPin(String pin) {
        state.enterPin(this, pin);
    }

    public void checkBalance() {
        state.checkBalance(this);
    }

    public void withdraw(double amount) {
        state.withdraw(this, amount);
    }

    public void ejectCard() {
        state.ejectCard(this);
    }

    public boolean validatePin(String pin) {
        return correctPin.equals(pin);
    }

    public void incrementPinAttempts() {
        pinAttempts++;
    }

    public void resetPinAttempts() {
        pinAttempts = 0;
    }

    public int getPinAttempts() {
        return pinAttempts;
    }

    public double getBalance() {
        return balance;
    }

    public double getCashAvailable() {
        return cashAvailable;
    }

    public void withdrawMoney(double amount) {
        balance -= amount;
        cashAvailable -= amount;
    }

    public void ejectCardPhysically() {
        System.out.println("Removing card from ATM...");
    }
}
