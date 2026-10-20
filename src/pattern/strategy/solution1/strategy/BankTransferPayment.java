package pattern.strategy.solution1.strategy;

public class BankTransferPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with bank transfer");
    }
}