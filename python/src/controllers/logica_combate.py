# python/logica_combate.py

# --- 2.1 Estado del personaje según % de vida ---
vida = 25.0
vida_max = 100.0
pct = (vida / vida_max) * 100

if pct <= 0:
    estado = 'MUERTO'
elif pct <= 25:
    estado = 'CRITICO'
elif pct <= 50:
    estado = 'HERIDO'
elif pct <= 75:
    estado = 'ESTABLE'
else:
    estado = 'SALUDABLE'

print(f'Vida: {vida:.0f}/{vida_max:.0f} ({pct:.0f}%)')
print(f'Estado: {estado}')

# --- 2.2 Tipo de ataque según clase (match Python 3.10+) ---
clase = 'Mago'
nivel_habilidad = 3

match clase:
    case 'Guerrero': tipo_ataque = 'Espada'
    case 'Mago':     tipo_ataque = 'Hechizo'
    case 'Arquero':  tipo_ataque = 'Flecha'
    case _:          tipo_ataque = 'Puno'

puede_usar_magia = (clase == 'Mago' and nivel_habilidad >= 3)

if puede_usar_magia:
    print('Bola de fuego!')
else:
    print(f'{tipo_ataque} basico')

# --- EJERCICIO 2A - Lógica de combate completa ---
vida_enemigo = 40
ataque = 35
nivel_jugador = 6

bonificacion = 10 if nivel_jugador >= 5 else 0
dano_total = ataque + bonificacion
vida_restante = vida_enemigo - dano_total

print(f'\nAtaque: {ataque} + Bonificacion: {bonificacion} = Dano total: {dano_total}')

if vida_restante <= 0:
    print('Enemigo derrotado! +50 XP')
elif vida_restante <= 20:
    print('Enemigo en estado critico')
else:
    print(f'Enemigo resiste. Vida restante: {vida_restante}')