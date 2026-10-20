package pattern.strategy.solution2.factory;

import pattern.strategy.solution2.strategy.PayPalPayment;
import pattern.strategy.solution2.strategy.PaymentStrategy;

public class PayPalPaymentProcessor extends PaymentProcessor {

    @Override
    protected PaymentStrategy createPaymentStrategy() {
        return new PayPalPayment();
    }
}