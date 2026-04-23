package rpg.app;

import rpg.modelo.Personaje;
import rpg.controlador.CombateController;
import rpg.vista.PersonajeView;

public class Main {

    public static void main(String[] args) {

        // Crear héroe
        Personaje heroe = new Personaje();
        heroe.nombre = "Gandalf";
        heroe.clase = "Mago";
        heroe.nivel = 5;
        heroe.vida = 80;
        heroe.vidaMax = 100;
        heroe.ataque = 35;
        heroe.defensa = 10;

        // Crear enemigo
        Personaje enemigo = new Personaje();
        enemigo.nombre = "Orco";
        enemigo.vida = 40;
        enemigo.vidaMax = 40;
        enemigo.defensa = 5;

        // MVC
        PersonajeView view = new PersonajeView();
        CombateController controller = new CombateController();

        // Mostrar estado inicial
        view.mostrarEstado(heroe);

        // Evaluar estado
        controller.evaluarEstado(heroe);

        // Tipo de ataque
        controller.tipoAtaque(heroe.clase, 3);

        // Combate completo
        controller.combateCompleto(heroe, enemigo);
    }
}