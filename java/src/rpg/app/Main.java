package rpg.app;

import rpg.modelo.Personaje;
import rpg.controlador.CombateController;
import rpg.vista.PersonajeView;

public class Main {

    public static void main(String[] args) {

        // Crear personaje
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

        view.mostrarEstado(heroe);

        controller.evaluarEstado(heroe);
        controller.atacar(heroe, enemigo);
    }
}