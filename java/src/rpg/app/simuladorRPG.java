package rpg.app;

public class SimuladorRPG {

    // ===== FUNCIÓN COMBATIR =====
    public static double combatir(double vidaHero, int ataqueHero, int defensaHero,
                                  double vidaEnemigo, int ataqueEnemigo) {

        int ronda = 1;

        while (vidaHero > 0 && vidaEnemigo > 0) {

            // Héroe ataca
            int danoHeroe = Math.max(ataqueHero - 5, 1); // defensa básica enemigo = 5
            vidaEnemigo -= danoHeroe;

            // Enemigo ataca
            int danoEnemigo = Math.max(ataqueEnemigo - defensaHero, 1);
            vidaHero -= danoEnemigo;

            System.out.println("Ronda " + ronda +
                    " | Heroe: " + vidaHero +
                    " | Enemigo: " + vidaEnemigo);

            ronda++;
        }

        return vidaHero; // retorna la vida restante del héroe
    }

    public static void main(String[] args) {

        // ===== HEROE =====
        double vidaHero = 80;
        double vidaMax = 80;
        int ataqueHero = 18;
        int defensaHero = 8;

        // ===== ENEMIGOS =====
        String[] nombres = {"Goblin", "Orco", "Dragon"};
        double[] vidas = {40, 70, 120};
        int[] ataques = {8, 14, 25};

        int enemigosDerrotados = 0;

        // ===== CICLO PRINCIPAL =====
        for (int i = 0; i < nombres.length; i++) {

            System.out.println("\n--- Combate contra " + nombres[i] + " ---");

            vidaHero = combatir(vidaHero, ataqueHero, defensaHero, vidas[i], ataques[i]);

            // ===== CONDICIONES =====
            if (vidaHero <= 0) {
                System.out.println("💀 El héroe ha muerto...");
                break;
            } else {
                System.out.println("✅ Derrotaste a " + nombres[i]);
                enemigosDerrotados++;

                // Curación
                vidaHero += 20;
                if (vidaHero > vidaMax) {
                    vidaHero = vidaMax;
                }

                System.out.println("❤️ Vida recuperada: " + vidaHero);
            }
        }

        // ===== RESULTADO FINAL =====
        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Enemigos derrotados: " + enemigosDerrotados);
        System.out.println("Vida restante del héroe: " + vidaHero);

        if (enemigosDerrotados == 3) {
            System.out.println("🏆 ¡VICTORIA TOTAL!");
        } else {
            System.out.println("❌ GAME OVER");
        }
    }
}