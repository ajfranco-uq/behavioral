package pattern.command.restaurant.solution;

import pattern.command.restaurant.solution.command.Command;

// Ahora OrderController no necesita conocer la clase Order. Solo recibe un objeto Command y ejecuta su método execute().
public class OrderController {

    public void executeCommand(Command command) {
        command.execute();
    }
}
