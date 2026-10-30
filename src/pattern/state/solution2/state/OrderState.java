package pattern.state.solution2.state;

import pattern.state.solution2.domain.Order;

public interface OrderState {
    String getName();

    default void pay(Order order, String paymentToken) {
        reject("pay");
    }

    default void ship(Order order, String destination) {
        reject("ship");
    }

    default void deliver(Order order) {
        reject("deliver");
    }

    default void cancel(Order order) {
        reject("cancel");
    }

    private void reject(String operation) {
        throw new IllegalStateException("Operation '" + operation
            + "' is not allowed when order state is " + getName() + ".");
    }
}
