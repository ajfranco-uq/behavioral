package pattern.state.problem;

public class Main {

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        player.pressPlay();
        player.pressPause();
        player.pressPlay();
        player.pressStop();
    }
}

/*
¿Qué problemas tiene esta solución?

La clase funciona, pero tiene varias limitaciones:
1. Muchos condicionales: cada operación debe conocer los diferentes estados.
2. Dificultad para crecer: si agregamos estados como BUFFERING, LOADING o ERROR, debemos modificar varios métodos.
3. Responsabilidades mezcladas: la misma clase administra el estado y define el comportamiento de cada estado.
4. Mayor riesgo de errores: podemos olvidar una condición o permitir una transición inválida.

*/
