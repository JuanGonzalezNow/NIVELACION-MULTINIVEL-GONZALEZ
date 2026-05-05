# --- DATOS DEL MAGO (Ejercicio 1A) ---
nombre_mago = 'Gandalf'
clase_mago = 'Mago'
nivel_mago = 5
vida_mago = 80.0
mana_mago = 120

# Mostrar en consola con el formato solicitado:
# 'Gandalf [Mago] Nv.5 | Vida: 80.0 | Mana: 120'
print(f"{nombre_mago} [{clase_mago}] Nv.{nivel_mago} | Vida: {vida_mago:.1f} | Mana: {mana_mago}")

# --- VERIFICACIÓN DE TIPOS (Como en tu ejemplo) ---
# El mana es un nuevo atributo tipo int
print(f"Tipo de mana: {type(mana_mago)}")

# app/views/mago_view.py
def mostrar_mago(nombre, clase, nivel, vida, mana):
    print(f"{nombre} [{clase}] Nv.{nivel} | Vida: {vida:.1f} | Mana: {mana}")
    print(f"Tipo de mana: {type(mana)}")
    
    # app/main.py
from models.mago_model import *
from views.mago_view import mostrar_mago

if __name__ == "__main__":
    mostrar_mago(nombre_mago, clase_mago, nivel_mago, vida_mago, mana_mago)