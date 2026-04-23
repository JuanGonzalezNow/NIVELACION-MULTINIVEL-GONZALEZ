package rpg.controlador;

import rpg.modelo.Personaje;
import rpg.vista.PersonajeView;

public class CombateController {

    private PersonajeView view = new PersonajeView();

    public void evaluarEstado(Personaje p) {
        double pct = (p.vida / p.vidaMax) * 100;

        String estado;

        if (pct <= 0) {
            estado = "MUERTO";
        } else if (pct <= 25) {
            estado = "CRITICO";
        } else if (pct <= 50) {
            estado = "HERIDO";
        } else if (pct <= 75) {
            estado = "ESTABLE";
        } else {
            estado = "SALUDABLE";
        }

        view.mostrarMensaje("Estado: " + estado);
    }

    public void atacar(Personaje jugador, Personaje enemigo) {

        int dano = jugador.ataque - enemigo.defensa;
        if (dano <= 0) dano = 1;

        enemigo.vida -= dano;

        if (enemigo.vida <= 0) {
            view.mostrarMensaje("Enemigo derrotado!");
        } else if (enemigo.vida <= 20) {
            view.mostrarMensaje("Enemigo en estado critico");
        } else {
            view.mostrarMensaje("Enemigo resiste. Vida: " + enemigo.vida);
        }
    }
}