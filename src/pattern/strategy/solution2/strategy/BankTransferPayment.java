package pattern.strategy.solution2.strategy;

public class BankTransferPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println(
                "Paying $" + amount + " with bank transfer"
        );
    }
    // "Cuando necesites procesar un pago mediante este processor, yo voy a crear BankTransferPayment."
}