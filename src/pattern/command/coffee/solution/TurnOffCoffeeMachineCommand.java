package pattern.command.coffee.solution;

public class TurnOffCoffeeMachineCommand implements Command {

    private final CoffeeMachine machine;

    public TurnOffCoffeeMachineCommand(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.turnOff();
    }
}
