package pattern.state.solution2.state;

import pattern.state.solution2.domain.Order;

public class PaidState implements OrderState {
    @Override public String getName() { return "PAID"; }

    @Override
    public void ship(Order order, String destination) {
        order.createShipment(destination);
        order.changeState(new ShippedState());
    }

    @Override
    public void cancel(Order order) {
        order.refundPayment();
        order.releaseInventory();
        order.changeState(new CancelledState());
    }
}
