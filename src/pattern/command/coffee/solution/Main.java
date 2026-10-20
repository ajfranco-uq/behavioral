package pattern.command.coffee.solution;

public class Main {

    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();
        RemoteControl remote = new RemoteControl();

        Command prepareCoffee = new PrepareCoffeeCommand(machine);
        Command turnOff = new TurnOffCoffeeMachineCommand(machine);

        remote.setCommand(prepareCoffee);
        remote.pressButton();

        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
// Command convierte cada acción en un objeto.
// Así, podemos agregar nuevos comandos sin modificar el control remoto,
// siempre que respeten la interfaz Command.
