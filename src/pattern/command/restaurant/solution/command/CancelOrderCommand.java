package pattern.command.restaurant.solution.command;

import pattern.command.restaurant.solution.Order;

public class CancelOrderCommand implements Command {

    private final Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.cancel();
    }
}
