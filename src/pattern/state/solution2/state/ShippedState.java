package pattern.state.solution2.state;

import pattern.state.solution2.domain.Order;

public class ShippedState implements OrderState {
    @Override public String getName() { return "SHIPPED"; }

    @Override
    public void deliver(Order order) {
        order.confirmDelivery();
        order.changeState(new DeliveredState());
    }
}
