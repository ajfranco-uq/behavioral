package pattern.command.coffee.solution;

// Definimos una forma estándar de ejecutar cualquier acción, sin importar qué dispositivo la realice.
public interface Command {
    void execute();
}
