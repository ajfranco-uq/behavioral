package pattern.strategy.solution1;

import pattern.strategy.solution1.strategy.BankTransferPayment;
import pattern.strategy.solution1.strategy.CardPayment;
import pattern.strategy.solution1.strategy.PayPalPayment;

public class Main {

    public static void main(String[] args) {

        // Pay with credit card
        PaymentService paymentService = new PaymentService(new CardPayment());
        paymentService.pay(100);

        // Change strategy: Pay with PayPal
        paymentService = new PaymentService(new PayPalPayment());
        paymentService.pay(250);

        // Change strategy: Pay with bank transfer
        paymentService = new PaymentService(new BankTransferPayment());
        paymentService.pay(500);
    }
}