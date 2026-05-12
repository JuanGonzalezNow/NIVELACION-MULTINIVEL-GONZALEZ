# controllers/inventario_controller.py
from models.inventario_model import inventario, xp, nivel, xp_necesario, batallas

# --- 3.1 Buscar item ---
def buscar_item(item):
    return item in inventario

# --- 3.2 while - Rondas de combate ---
def simular_combate(vida_hero=80, vida_enemigo=60):
    ronda = 1
    while vida_hero > 0 and vida_enemigo > 0:
        vida_enemigo -= 15
        vida_hero -= 10
        print(f'Ronda {ronda}: Hero={vida_hero} | Enemigo={vida_enemigo}')
        ronda += 1
    return 'VICTORIA!' if vida_hero > 0 else 'DERROTA'

# --- 3A - Acumular XP ---
def acumular_xp():
    xp_actual = xp
    nivel_actual = nivel
    for xp_ganado in batallas:
        xp_actual += xp_ganado
        if xp_actual >= xp_necesario:
            nivel_actual += 1
            xp_actual -= xp_necesario
            print(f'Nivel {nivel_actual} alcanzado! XP restante: {xp_actual}')
    return nivel_actual, xp_actual