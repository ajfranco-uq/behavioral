package pattern.command.coffee.solution;

public class PrepareCoffeeCommand implements Command {

    private final CoffeeMachine machine;

    public PrepareCoffeeCommand(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.prepareCoffee();
    }
}
