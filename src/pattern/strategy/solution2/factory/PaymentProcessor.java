package pattern.strategy.solution2.factory;

import pattern.strategy.solution2.strategy.PaymentStrategy;

public abstract class PaymentProcessor {

    public void processPayment(double amount) {
        PaymentStrategy strategy = createPaymentStrategy();
        strategy.pay(amount);
    }

    protected abstract PaymentStrategy createPaymentStrategy(); // Factory Method -> ¿Qué objeto concreto creo?
}