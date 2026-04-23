package rpg.controlador;

public class LogicaCombate {

    public static void main(String[] args) {

        // ===== 2.1 Estado del personaje =====
        double vida = 25.0;
        double vidaMax = 100.0;
        String estado;

        double pct = (vida / vidaMax) * 100;

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

        System.out.println("Estado: " + estado);

        // ===== 2.2 Tipo de ataque (switch) =====
        String clase = "Mago";
        int nivelHabilidad = 3;

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

        // Condición compuesta
        boolean puedeUsarMagia =
                clase.equals("Mago") && nivelHabilidad >= 3;

        if (puedeUsarMagia) {
            System.out.println("Bola de fuego!");
        } else {
            System.out.println(tipoAtaque + " basico");
        }

        // ===== EJERCICIO 2A =====
        int vidaEnemigo = 40;
        int ataque = 35;
        int nivelJugador = 6;

        int bonificacion = (nivelJugador >= 5) ? 10 : 0;

        int danoTotal = ataque + bonificacion;
        int vidaRestante = vidaEnemigo - danoTotal;

        if (vidaRestante <= 0) {
            System.out.println("Enemigo derrotado! +50 XP");
        } else if (vidaRestante <= 20) {
            System.out.println("Enemigo en estado critico");
        } else {
            System.out.println("Enemigo resiste. Vida restante: " + vidaRestante);
        }
    }
}