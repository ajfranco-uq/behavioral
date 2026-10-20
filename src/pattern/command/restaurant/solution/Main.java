package pattern.command.restaurant.solution;

import pattern.command.restaurant.solution.command.CancelOrderCommand;
import pattern.command.restaurant.solution.command.Command;
import pattern.command.restaurant.solution.command.ConfirmOrderCommand;
import pattern.command.restaurant.solution.command.PrepareOrderCommand;

// La clase Main crea el pedido, construye los comandos y decide cuál ejecutar.

public class Main {

    public static void main(String[] args) {

        Order order = new Order(101);
        OrderController controller = new OrderController();

        Command confirm = new ConfirmOrderCommand(order);
        Command prepare = new PrepareOrderCommand(order);
        Command cancel = new CancelOrderCommand(order);

        controller.executeCommand(confirm);
        controller.executeCommand(prepare);

        System.out.println(
            "Current status: " + order.getStatus()
        );

        controller.executeCommand(cancel);

        System.out.println(
            "Final status: " + order.getStatus()
        );
    }
}
