# controllers/simulador_controller.py
from models.personaje_model import Personaje

def calcular_dano(ataque: int, defensa: int) -> int:
    dano = ataque - defensa
    return dano if dano > 0 else 1

def combatir(heroe: Personaje, enemigo: Personaje):
    print(f'\n⚔️  {heroe.nombre} vs {enemigo.nombre}')
    ronda = 1
    while heroe.vida > 0 and enemigo.vida > 0:
        # Héroe ataca
        dano_heroe = calcular_dano(heroe.puntos_ataque, enemigo.puntos_defensa)
        enemigo.vida -= dano_heroe

        # Enemigo contraataca (si sigue vivo)
        if enemigo.vida > 0:
            dano_enemigo = calcular_dano(enemigo.puntos_ataque, heroe.puntos_defensa)
            heroe.vida -= dano_enemigo

        print(f'  Ronda {ronda}: {heroe.nombre}={heroe.vida:.0f}HP | {enemigo.nombre}={max(enemigo.vida, 0):.0f}HP')
        ronda += 1

    if heroe.vida > 0:
        heroe.esta_vivo = True
        enemigo.esta_vivo = False
        return True  # héroe ganó
    else:
        heroe.esta_vivo = False
        return False  # héroe perdió

def aplicar_curacion(heroe: Personaje, cantidad: float = 20.0):
    heroe.vida = min(heroe.vida + cantidad, heroe.vida_maxima)
    print(f'  💊 {heroe.nombre} recupera {cantidad} HP -> {heroe.vida:.0f}HP')