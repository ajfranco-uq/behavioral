package pattern.strategy.solution1.strategy;

public class CardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with credit card");
    }
}