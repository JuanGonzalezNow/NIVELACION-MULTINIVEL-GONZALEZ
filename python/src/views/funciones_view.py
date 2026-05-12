# views/funciones_view.py
from controllers.funciones_controller import (
    calcular_dano, aplicar_curacion, mostrar_estado, subir_nivel
)
from models.funciones_model import (
    nombre, vida, vida_maxima, nivel, ataque, defensa, xp, xp_necesario
)

print('=== PRUEBA DE FUNCIONES ===')

d = calcular_dano(ataque, defensa)
print(f'Dano: {d}')

nueva_vida = aplicar_curacion(vida, 80, vida_maxima)
mostrar_estado(nombre, nueva_vida, nivel)

# Prueba subir_nivel: xp=110 debe subir, xp=80 no debe subir
subir_nivel(110, xp_necesario, nivel)
subir_nivel(80, xp_necesario, nivel)