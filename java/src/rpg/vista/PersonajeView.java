package rpg.vista;

import rpg.modelo.Personaje;

public class PersonajeView {

    public void mostrarEstado(Personaje p) {
        System.out.println(
            p.nombre + " [" + p.clase + "] Nv." + p.nivel +
            " | Vida: " + p.vida
        );
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}