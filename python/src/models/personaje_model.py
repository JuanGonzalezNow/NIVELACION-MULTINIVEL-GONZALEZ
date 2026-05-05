# Aquí definimos la estructura del personaje (MODELO)
class Personaje:
    def __init__(self, nombre, nivel, vida, vida_maxima, clase, puntos_ataque, puntos_defensa, mana=0):
        self.nombre = nombre
        self.nivel = nivel
        self.vida = float(vida)
        self.vida_maxima = float(vida_maxima)
        self.esta_vivo = True
        self.clase = clase
        self.puntos_ataque = puntos_ataque
        self.puntos_defensa = puntos_defensa
        self.mana = mana # Nuevo atributo para el ejercicio