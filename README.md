# CCU ha (Colección de Código Universitario Harry) :pencil2: :books:

Consiste básicamente en colocar las practicas que he estado desarrollado en los cursos de la universidad.

Los temas, practicas y algoritmos desarrollados serán variados. Sus contribuciones serán siempre bien recibidas.
 
## Analizador Sintactico (syntactic_analyzer.go) - GoLang
*Analizador Sintactico (syntactic_analyzer.go) - GoLang.*
Se propone crear un algoritmo el cual pueda determinar los tipos de símbolos o palabras reservadas que se tienen en un fichero escrito. ejemplo como un compilador el cual analice y determine que la sintaxis del código esta bien escrito.
[https://es.wikipedia.org/wiki/Analizador_sint%C3%A1ctico]

## Crear Comandos
En este apartado se propone desarrollar programas que simulen los comandos que vienen por defecto en el sistema operativo (Windows o GNU/Linux) cada uno con sus correspondientes argumentos.

### mycat.go
El algoritmo *mycat.go* simulara el comando ‘cat’, lo cual nos permite visualizar el contenido de un archivo; en opciones tenemos:
1.	-c : cantidad, muestra la cantidad de caracteres que contiene el archivo.
2.	-n : enumeración, enumera las lineas del archivo.
3.  -m : enumeración, esta enumeración ignora las lineas en blanco.

### mygrep.go
(no terminado) El algoritmo *mygrep.go* simulara el comando ‘grep’, este comando nos permite realizar busqueda de una palabra en un archivo; en opciones tenemos:
1.  -v : grep -v hola pp.txt lista las líneas que no contengan la cadena hola del archivo pp.txt.
2.  -n : grep -n hola pp.txt las líneas concordantes con la cadena hola del archivo pp.txt se mostrarán acompañadas del número de línea.

*El <b>settings.jar</b> son las configuraciones que utilizarón en el IDE.*

## Scripts .sh & .bat
*Elabore dos programas por lotes uno para el S.O. Ubuntu y otro para Windows.*

Ambos programas deben tener la misma idea, es decir ofrecer el mismo resultado. La intención es observar claramente la diferencia que existe al momento de programar un programa por lotes (batch) para Windows y un script o programa por lotes para Unix.

Los archivos <b>scriptUnix.sh</b> y <b>scriptMSDOS.bat</b> tendrán la tarea de realizar versiones de copias de cualquier archivo o directorio.

### ¿Funcionalidad?
* Esto podría utilizarse para realizar copias de seguridad de cualquier estructura de directorio.

### ¿En que consiste?
_Consiste en especificar una ruta y un valor numérico._

* **FUN**> Sera la ruta del archivo o directorio que se utilizara para realizar el respaldo o copia.

* **Tiempo**> Es el tiempo que se utilizara para realizar la copia, el valor predeterminado es 60 segundos.

## Simulador - Estado de los Procesos
Elabore un programa, en un lenguaje de programación conocido, que simule los tres (3) Estados de los Procesos, en las cinco (5) transiciones de los procesos. (ver el documento de clase).

<img align="center" width="650px" height="250px" src="https://elpuig.xeill.net/Members/vcarceler/c1/didactica/apuntes/ud3/na7/modelo_5_estados.png">

## Expresión Regular - Solving.py
Consiste en desarrollar un algoritmo capas de cumplir las reglas del siguiente diagrama 
![Diagrama](https://github.com/HarryAlvarado28/CCU_ha/blob/master/img/pdc.png)
El algoritmo llamado **solving.py** resuelve el ejercicio, he aqui un ejemplo del resultado.
````console
hky:CCU_ha harry$ python3 solving.py 
Dime una cadena: ababbbaabbabba          
-------------------------------------
Cadena Base: [ ababbbaabbabba ] tamaño: [ 14 ]
Estado Inicial, el primer simbolo es:  a
Estado 1
Estado 2
Estado 1
Estado 2
Estado 3
¡La cadena [ ababb ] es ACEPTADA!
-------------------------------------
-> Siguiente Cadena: [ baabbabba ] tamaño: [ 9 ]
Estado Inicial, el primer simbolo es:  b
Estado 4
Estado 1
Estado 1
Estado 2
Estado 3
¡La cadena [ baabb ] es ACEPTADA!
-------------------------------------
-> Siguiente Cadena: [ abba ] tamaño: [ 4 ]
Estado Inicial, el primer simbolo es:  a
Estado 1
Estado 2
Estado 3
¡La cadena [ abb ] es ACEPTADA!
-------------------------------------
-> Siguiente Cadena: [ a ] tamaño: [ 1 ]
Estado Inicial, el primer simbolo es:  a
Estado 1
¡[ESTADO 1] cadena [ a ] NO es ACEPTADA!
hky:CCU_ha harry$
````
