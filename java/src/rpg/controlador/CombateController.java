package rpg.controlador;

import rpg.modelo.Personaje;
import rpg.vista.PersonajeView;

public class CombateController {

    private PersonajeView view = new PersonajeView();

    // ===== Estado del personaje =====
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

    // ===== Tipo de ataque =====
    public void tipoAtaque(String clase, int nivelHabilidad) {

        String tipoAtaque;

        switch (clase) {
            case "Guerrero":
                tipoAtaque = "Espada";
                break;
            case "Mago":
                tipoAtaque = "Hechizo";
                break;
            case "Arquero":
                tipoAtaque = "Flecha";
                break;
            default:
                tipoAtaque = "Puño";
        }

        boolean puedeUsarMagia =
                clase.equals("Mago") && nivelHabilidad >= 3;

        if (puedeUsarMagia) {
            view.mostrarMensaje("Bola de fuego!");
        } else {
            view.mostrarMensaje(tipoAtaque + " basico");
        }
    }

    // ===== Combate completo (EJERCICIO 2A) =====
    public void combateCompleto(Personaje jugador, Personaje enemigo) {

        int bonificacion = (jugador.nivel >= 5) ? 10 : 0;

        int danoTotal = jugador.ataque + bonificacion;
        int vidaRestante = (int) enemigo.vida - danoTotal;

        if (vidaRestante <= 0) {
            view.mostrarMensaje("Enemigo derrotado! +50 XP");
        } else if (vidaRestante <= 20) {
            view.mostrarMensaje("Enemigo en estado critico");
        } else {
            view.mostrarMensaje("Enemigo resiste. Vida restante: " + vidaRestante);
        }
    }
}