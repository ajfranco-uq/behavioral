package pattern.state.solution2.state;

import pattern.state.solution2.domain.Order;

public class CreatedState implements OrderState {
    @Override public String getName() { return "CREATED"; }

    @Override
    public void pay(Order order, String paymentToken) {
        order.capturePayment(paymentToken);
        order.changeState(new PaidState());
    }

    @Override
    public void cancel(Order order) {
        order.releaseInventory();
        order.changeState(new CancelledState());
    }
}
