package pattern.strategy.solution2.factory;

import pattern.strategy.solution2.strategy.CardPayment;
import pattern.strategy.solution2.strategy.PaymentStrategy;

public class CardPaymentProcessor extends PaymentProcessor {

    @Override
    protected PaymentStrategy createPaymentStrategy() {
        return new CardPayment();
    }

    // "Cuando necesites procesar un pago mediante este processor, yo voy a crear CardPayment."
}