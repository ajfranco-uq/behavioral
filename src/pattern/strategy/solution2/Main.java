package pattern.strategy.solution2;

import pattern.strategy.solution2.factory.BankTransferPaymentProcessor;
import pattern.strategy.solution2.factory.CardPaymentProcessor;
import pattern.strategy.solution2.factory.PayPalPaymentProcessor;
import pattern.strategy.solution2.factory.PaymentProcessor;

public class Main {

    public static void main(String[] args) {

        PaymentProcessor processor;

        // Credit card
        processor = new CardPaymentProcessor();
        processor.processPayment(100);

        // PayPal
        processor = new PayPalPaymentProcessor();
        processor.processPayment(200);

        // Bank transfer
        processor = new BankTransferPaymentProcessor();
        processor.processPayment(300);
    }

    //Factory Method crea la Strategy; Strategy define el comportamiento que se ejecutará.

//    En este ejemplo, no necesitamos necesariamente ambos patrones.
//    Podríamos utilizar solamente Strategy:

//    PaymentProcessor processor = new PaymentProcessor(new PayPalPayment());
//    processor.processPayment(200);

//    O solamente Factory Method si nuestro problema fuera exclusivamente la creación.
//    Los combinamos aquí para enseñar que pueden coexistir y que sus responsabilidades son diferentes.


}