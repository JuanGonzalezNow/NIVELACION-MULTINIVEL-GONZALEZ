package rpg.app;

import rpg.modelo.Personaje;
import rpg.controlador.CombateController;
import rpg.vista.PersonajeView;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // ... (Tu código inicial de creación de personajes)
        Personaje heroe = new Personaje();
        heroe.nombre = "Gandalf";
        heroe.clase = "Mago";
        heroe.nivel = 5;
        heroe.vida = 80;
        heroe.vidaMax = 100;
        heroe.ataque = 35;
        heroe.defensa = 10;

        Personaje enemigo = new Personaje();
        enemigo.nombre = "Orco";
        enemigo.vida = 40;
        enemigo.vidaMax = 40;
        enemigo.defensa = 5;

        CombateController controller = new CombateController();
        PersonajeView view = new PersonajeView();

        // --- PRUEBA BLOQUE 3: Ciclos ---
        ArrayList<String> mochila = new ArrayList<>();
        mochila.add("Vara de Istari");
        mochila.add("Pocion de Mana");
        mochila.add("Pan de Lembas");
        
        controller.gestionarInventario(mochila);

        // --- PRUEBA BLOQUE 4: Funciones e Integración ---
        view.mostrarMensaje("\n--- Iniciando Combate por Rondas ---");
        controller.simularCombate(heroe, enemigo);

        // Prueba de curación
        controller.aplicarCuracion(heroe, 30);

        // Prueba de subida de nivel (Ejercicio 4A)
        heroe.nivel = controller.subirNivel(110, 100, heroe.nivel);
        view.mostrarEstado(heroe);
    }
}