package rpg.controlador;

import rpg.modelo.Personaje;
import rpg.vista.PersonajeView;
import java.util.ArrayList;

public class CombateController {

    private PersonajeView view = new PersonajeView();

    // ... (Métodos anteriores: evaluarEstado, tipoAtaque, combateCompleto)

    // ===== BLOQUE 3: Ciclos (Inventario) =====
    public void gestionarInventario(ArrayList<String> inventario) {
        view.mostrarMensaje("=== INVENTARIO ===");
        // for con índice (3.1)
        for (int i = 0; i < inventario.size(); i++) {
            view.mostrarMensaje((i + 1) + ". " + inventario.get(i));
        }
    }

    // ===== BLOQUE 3: Ciclos (Simulación de Rondas) =====
    public void simularCombate(Personaje heroe, Personaje enemigo) {
        int ronda = 1;
        // Ciclo while (3.2)
        while (heroe.vida > 0 && enemigo.vida > 0) {
            int danoAlEnemigo = calcularDano(heroe.ataque, enemigo.defensa);
            enemigo.vida -= danoAlEnemigo;

            int danoAlHeroe = calcularDano(15, heroe.defensa); // Daño base enemigo 15
            heroe.vida -= danoAlHeroe;

            view.mostrarMensaje("Ronda " + ronda + ": Heroe HP=" + heroe.vida + " | Enemigo HP=" + enemigo.vida);
            ronda++;
        }
        view.mostrarMensaje(heroe.vida > 0 ? "VICTORIA!" : "DERROTA");
    }

    // ===== BLOQUE 4: Funciones / Métodos Reutilizables =====
    
    // Método que retorna el daño real (4.1)
    public int calcularDano(int ataque, int defensa) {
        int dano = ataque - defensa;
        return dano > 0 ? dano : 1;
    }

    // Método para curar sin pasar el máximo (4.1)
    public void aplicarCuracion(Personaje p, double curacion) {
        double nuevaVida = p.vida + curacion;
        p.vida = (nuevaVida > p.vidaMax) ? p.vidaMax : nuevaVida;
        view.mostrarMensaje(p.nombre + " se ha curado. Vida actual: " + p.vida);
    }

    // Ejercicio 4A: Subir Nivel
    public int subirNivel(int xpActual, int xpNecesario, int nivelActual) {
        if (xpActual >= xpNecesario) {
            nivelActual++;
            view.mostrarMensaje("¡SUBIDA DE NIVEL! Ahora eres nivel: " + nivelActual);
            return nivelActual;
        }
        return nivelActual;
    }
}