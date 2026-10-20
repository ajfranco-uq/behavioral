package pattern.command.restaurant.solution.command;

import pattern.command.restaurant.solution.Order;

public class PrepareOrderCommand implements Command {

    private final Order order;

    public PrepareOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.sendToKitchen();
    }
}
