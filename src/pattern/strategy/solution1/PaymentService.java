package pattern.strategy.solution1;

import pattern.strategy.solution1.strategy.PaymentStrategy;

public class PaymentService {

    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        strategy.pay(amount);
    }
}