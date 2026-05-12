# controllers/funciones_controller.py

def calcular_dano(ataque: int, defensa: int) -> int:
    '''Retorna el daño real (mínimo 1)'''
    dano = ataque - defensa
    return dano if dano > 0 else 1

def aplicar_curacion(vida: float, cur: float, max_vida: float) -> float:
    '''Cura sin pasar el máximo'''
    return min(vida + cur, max_vida)

def mostrar_estado(nombre: str, vida: float, nivel: int):
    '''Imprime el estado del personaje'''
    print(f'{nombre} [Nv{nivel}] HP: {vida:.0f}')

def subir_nivel(xp_actual: int, xp_necesario: int, nivel_actual: int) -> int:
    '''Sube de nivel si tiene XP suficiente'''
    if xp_actual >= xp_necesario:
        nivel_actual += 1
        xp_actual = 0
        print(f'Subiste al nivel {nivel_actual}!')
    else:
        print(f'XP insuficiente. Necesitas {xp_necesario - xp_actual} XP mas.')
    return nivel_actual