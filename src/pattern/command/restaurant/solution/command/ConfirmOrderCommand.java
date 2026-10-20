package pattern.command.restaurant.solution.command;

import pattern.command.restaurant.solution.Order;

public class ConfirmOrderCommand implements Command {

    private final Order order;

    public ConfirmOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.confirm();
    }
}
