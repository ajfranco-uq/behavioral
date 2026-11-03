package pattern.state.solution2;

public interface ATMState {

    void insertCard(ATM atm);

    void enterPin(ATM atm, String pin);

    void checkBalance(ATM atm);

    void withdraw(ATM atm, double amount);

    void ejectCard(ATM atm);
}
