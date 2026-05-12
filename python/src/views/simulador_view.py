# views/simulador_view.py
from models.personaje_model import Personaje
from controllers.simulador_controller import combatir, aplicar_curacion

def run_simulador():
    # Héroe
    heroe = Personaje(
        nombre='Aragorn', nivel=2, vida=80, vida_maxima=80,
        clase='Guerrero', puntos_ataque=18, puntos_defensa=8
    )

    # Lista de enemigos
    enemigos = [
        Personaje('Goblin',  1, 40,  40,  'Enemigo', puntos_ataque=8,  puntos_defensa=2),
        Personaje('Orco',    1, 70,  70,  'Enemigo', puntos_ataque=14, puntos_defensa=4),
        Personaje('Dragon',  1, 120, 120, 'Enemigo', puntos_ataque=25, puntos_defensa=6),
    ]

    print('=== 🏰 SIMULADOR RPG - COMBATE FINAL ===')
    derrotados = 0

    for enemigo in enemigos:
        if not heroe.esta_vivo:
            break

        gano = combatir(heroe, enemigo)

        if gano:
            derrotados += 1
            print(f'  ✅ {enemigo.nombre} derrotado!')
            if derrotados < len(enemigos):  # curación entre combates
                aplicar_curacion(heroe)
        else:
            print(f'  💀 {heroe.nombre} fue derrotado por {enemigo.nombre}')
            break

    print('\n=== RESULTADO FINAL ===')
    print(f'Enemigos derrotados: {derrotados}/3')
    if heroe.esta_vivo:
        print(f'🏆 VICTORIA! Vida restante: {heroe.vida:.0f}HP')
    else:
        print('☠️  DERROTA')

if __name__ == '__main__':
    run_simulador()