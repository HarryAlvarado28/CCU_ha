# CCU ha (Colección de Código Universitario Harry)

Consiste básicamente en colocar las practicas que he estado desarrollado en los cursos de la universidad.

Los temas, practicas y algoritmos desarrollados serán variados. Sus contribuciones serán siempre bien recibidas.
 
## Analizador Sintactico (syntactic_analyzer.go) - GoLang
*Analizador Sintactico (syntactic_analyzer.go) - GoLang.*
Se propone crear un algoritmo el cual pueda determinar los tipos de símbolos o palabras reservadas que se tienen en un fichero escrito. ejemplo como un compilador el cual analice y determine que la sintaxis del código esta bien escrito.
[https://es.wikipedia.org/wiki/Analizador_sint%C3%A1ctico]

## Crear Comandos
En este apartado se propone desarrollar programas que simulen los comandos que vienen por defecto en el sistema operativo (Windows o GNU/Linux) cada uno con sus correspondientes argumentos.

### mysort.go
El algoritmo *mysort.go* simulara el comando ‘sort’, este comando nos permite básicamente ordenar los datos que se encuentran dentro de un archivo; en opciones tenemos:
1.	-i : inverso, mostrara los datos de forma inversa.
2.	-e : empieza, empezara el orden desde el valor especificado.

### mycat.go
El algoritmo *mycat.go* simulara el comando ‘cat’, lo cual nos permite visualizar el contenido de un archivo; en opciones tenemos:
1.	-c : cantidad, muestra la cantidad de caracteres que contiene el archivo.
2.	-n : enumeración, enumera las lineas del archivo.
3.  -m : enumeración, esta enumeración ignora las lineas en blanco.

### mygrep.go
El algoritmo *mygrep.go* simulara el comando ‘grep’, este comando nos permite realizar busqueda de una palabra en un archivo; en opciones tenemos:
1.  -v : grep -v hola pp.txt lista las líneas que no contengan la cadena hola del archivo pp.txt.
2.  -n : grep -n hola pp.txt las líneas concordantes con la cadena hola del archivo pp.txt se mostrarán acompañadas del número de línea.

*El <b>settings.jar</b> son las configuraciones que utilizarón en el IDE.*