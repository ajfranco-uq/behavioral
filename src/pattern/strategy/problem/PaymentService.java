package pattern.strategy.problem;

public class PaymentService {

    public void pay(String method, double amount) {

        if (method.equals("CARD")) {
            // Pay with card

        } else if (method.equals("PAYPAL")) {
            // Pay with PayPal

        } else if (method.equals("BANK")) {
            // Pay with bank transfer
        }
    }
}