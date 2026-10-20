package pattern.strategy.solution2.factory;

import pattern.strategy.solution2.strategy.BankTransferPayment;
import pattern.strategy.solution2.strategy.PaymentStrategy;

public class BankTransferPaymentProcessor
        extends PaymentProcessor {

    @Override
    protected PaymentStrategy createPaymentStrategy() {
        return new BankTransferPayment();
    }
}