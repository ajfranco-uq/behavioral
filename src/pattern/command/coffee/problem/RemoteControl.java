package pattern.command.coffee.problem;

// PROBLEMA: La clase RemoteControl conoce directamente a CoffeeMachine y sus operaciones.

// Si queremos controlar otro dispositivo, por ejemplo, una lámpara,
// tendríamos que modificar el control remoto para agregar nuevos métodos.
class RemoteControl {

    private final CoffeeMachine coffeeMachine;

    public RemoteControl(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void pressCoffeeButton() {
        coffeeMachine.prepareCoffee();
    }

    public void pressPowerButton() {
        coffeeMachine.turnOff();
    }
}