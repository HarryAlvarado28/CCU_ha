import time
# import sys

def s4(cadena, posicion):
    posicion += 1
    time.sleep(1)
    print("Estado 4")
    if len(cadena) > posicion:
        if cadena[posicion] == "a":
            return s1(cadena, posicion)
        elif cadena[posicion] == "b":
            return s4(cadena, posicion)
        else:
            return print("¡Se a encontrado uno o más Simbolos No Validos!")
    else:
        print("¡[ESTADO 4] cadena [", cadena, "] NO es ACEPTADA!")
        return

def s1(cadena, posicion):
    time.sleep(1)
    posicion += 1
    print("Estado 1")
    if len(cadena) > posicion:
        if cadena[posicion] == "a":
            return s1(cadena, posicion)
        elif cadena[posicion] == "b":
            return s2(cadena, posicion)
        else:
            return print("¡Se a encontrado uno o más Simbolos No Validos!")
    else:
        print("¡[ESTADO 1] cadena [", cadena, "] NO es ACEPTADA!")
        return

def s2(cadena, posicion):
    time.sleep(1)
    posicion += 1
    print("Estado 2")
    if len(cadena) > posicion:
        if cadena[posicion] == "a":
            return s1(cadena, posicion)
        elif cadena[posicion] == "b":
            return s3(cadena, posicion)
        else:
            return print("¡Se a encontrado uno o más Simbolos No Validos!")
    else:
        print("¡[ESTADO 2] cadena [", cadena, "] NO es ACEPTADA!")
        return

def s3(cadena, posicion):
    time.sleep(1)
    print("Estado 3")
    proxima_cadena = cadena[posicion+1:]
    cadena_lista = cadena[:posicion+1]
    print("¡La cadena [", cadena_lista, "] es ACEPTADA!")
    if not (len(cadena)-1 == posicion):
        print("-------------------------------------")
        time.sleep(1)
        print ("-> Siguiente Cadena: [", proxima_cadena, "] tamaño: [", len(proxima_cadena),"]")
        s0(proxima_cadena)

def s0(s):
    time.sleep(1)
    print("Estado Inicial, el primer simbolo es: ", s[0])
    if s[0] == "a":
        return s1(s, 0)
    elif s[0] == "b":
        return s4(s, 0)

if __name__ == "__main__":
    # sys.setrecursionlimit(15000)
    try:
        cadena = input('Dime una cadena: ')
        print("-------------------------------------")
        if len(cadena) > 2:
            print ("Cadena Base: [", cadena, "] tamaño: [", len(cadena),"]")
            s0(cadena)
        else:
            print("La cadena es menor a (3) tres caracteres, no cumple con la expresión regular básica")
    except:
        print("¡Algo a salido MAL!")
