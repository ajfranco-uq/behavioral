package pattern.mediator.solution1;

public class Main {

    public static void main(String[] args) {

        AirTrafficControl controlTower = new ControlTower();

        Airplane airplane1 = new Airplane("AV101", controlTower);
        Airplane airplane2 = new Airplane("AV202", controlTower);
        Airplane airplane3 = new Airplane("AV303", controlTower);

        airplane1.requestLanding();
        airplane2.requestLanding();
        airplane1.releaseRunway();
        airplane2.requestLanding();
        airplane3.requestTakeOff();
    }
}

/*
¿Qué conseguimos con Mediator?

Antes:
- Cada avión tendría que conocer a los demás.
- Los aviones tendrían que coordinar directamente sus operaciones.
- Agregar un nuevo avión podría requerir modificar las relaciones existentes.

Después:
- Cada avión conoce únicamente al mediador.
- La torre centraliza las reglas de coordinación.
- Podemos agregar nuevos aviones sin modificar los existentes.
- La lógica de comunicación está separada de los objetos participantes.
*/