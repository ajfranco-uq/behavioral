package pattern.command.coffee.solution;

// El control remoto recibe un comando y lo ejecuta.
// No necesita conocer la clase concreta del comando ni los detalles de la máquina.
public class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute(); // El control remoto solo conoce la interfaz Command. No necesita llamar directamente a prepareCoffee() ni a turnOff().
        }
    }
}
