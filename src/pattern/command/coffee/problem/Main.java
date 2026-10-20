package pattern.command.coffee.problem;

public class Main {

    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();

        RemoteControl remote = new RemoteControl(machine);

        remote.pressCoffeeButton();
        remote.pressPowerButton();
    }
}
