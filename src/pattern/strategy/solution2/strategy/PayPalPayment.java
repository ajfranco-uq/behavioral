package pattern.strategy.solution2.strategy;

public class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println(
                "Paying $" + amount + " with PayPal"
        );
    }
    // "Cuando necesites procesar un pago mediante este processor, yo voy a crear PayPalPayment."
}