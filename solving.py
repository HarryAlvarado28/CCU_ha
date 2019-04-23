import time
# import sys

def s4(cadena, posicion):
    posicion += 1
    time.sleep(1)
    print("Estado 4")
    # print("posicion:: ",posicion, " la cadena es: ",len(cadena))
    if len(cadena) > posicion:
        if cadena[posicion] == "a":
            return s1(cadena, posicion)
        elif cadena[posicion] == "b":
            print(" estado 4-posicion:: ", posicion)
            return s4(cadena, posicion)
        else:
            print("posicion:else: ", posicion)
            return
    else:
        print("¡CADENA NO VALIDA!-ESTADO 4::")
        # print("CADENA NO VALIDA-EST4-ELSEposicion:: ",posicion, " la cadena es: ",len(cadena))
        return

def s1(cadena, posicion):
    time.sleep(1)
    posicion += 1
    print("Estado 1")
    # print("posicion:: ",posicion, " la cadena es: ",len(cadena))
    if len(cadena) > posicion:
        if cadena[posicion] == "a":
            return s1(cadena, posicion)
        elif cadena[posicion] == "b":
            return s2(cadena, posicion)
        else:
            return
    else:
        print("¡CADENA NO VALIDA!-ESTADO 1::")
        # print("CADENA NO VALIDA-EST1-ELSEposicion:: ",posicion, " la cadena es: ",len(cadena))
        return

def s2(cadena, posicion):
    time.sleep(1)
    # print("posicion:: ",posicion)
    posicion += 1
    print("Estado 2")
    # print("posicion:: ",posicion, " la cadena es: ",len(cadena))
    if len(cadena) > posicion:
        if cadena[posicion] == "a":
            return s1(cadena, posicion)
        elif cadena[posicion] == "b":
            return s3(cadena, posicion)
        else:
            return
    else:
        print("¡CADENA NO VALIDA!-ESTADO 2::")
        # print("CADENA NO VALIDA-EST2-ELSEposicion:: ",posicion, " la cadena es: ",len(cadena))
        return

def s3(cadena, posicion):
    time.sleep(1)
    print("Estado 3")
    if (len(cadena)-1 == posicion):
        print("Estado de ACEPTACIÓN")
    else:
        print("¡Cadena NO Valida!")

def s0(s):
    time.sleep(1)
    print("Estado Inicio, el primer simbolo es: ",s[0])
    if s[0] == "a":
        return s1(s, 0)
    elif s[0] == "b":
        return s4(s, 0)

if __name__ == "__main__":
    # sys.setrecursionlimit(15000)
    try:
        cadena = input('Dime una cadena: ')
        if len(cadena) > 2:
            print ("Cadena: [", cadena, "] tamaño: [", len(cadena),"]")
            s0(cadena)
            time.sleep(5)
        else:
            print("La cadena es menor a (3) tres caracteres, no cumple con la expresión regular básica")

    except:
        print("¡Algo a salido MAL!")
