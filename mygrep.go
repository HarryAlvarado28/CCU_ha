package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
)

func main() {

	if len(os.Args) == 3 {
		a := os.Args[1]
		b := os.Args[2]
		bArgs(a, b)
	} else if len(os.Args) == 4 {
		a := os.Args[1]
		b := os.Args[2]
		c := os.Args[3]
		cArgs(a, b, c)
	} else {
		log.Fatalln("\n" +
			"grep [ -v | -n ] [patrón] <fileName>" +
			"\n	-v : grep -v hola pp.txt lista las líneas que no contengan la cadena hola del archivo pp.txt." +
			"\n	-n : grep -n hola pp.txt las líneas concordantes con la cadena hola del archivo pp.txt se mostrarán acompañadas del número de línea.")
	}
}

func bArgs(string1, string2 string) {
	myFile, err := ioutil.ReadFile(string2)
	ifErrRead_grep(err != nil) //if it goes wrong, panic

	myFile = append(myFile, 03)
	j := 0
	k := 0
	n := 0
	tag := 0
	for i := 0; i < len(myFile); i++ {
		if myFile[i] == byte(10) || myFile[i] == byte(03) {
			for ; k < i; k += len(string1) {
				if len(string1) < (i - k) {
					if string1 == string(myFile[k:k+(len(string1))]) {
						//fmt.Println(string(myFile)[k : k + (len(string1))])
						tag = 1
					}

				}
			}
			n += 1
			//fmt.Print(" ", n, "  ")
			for ; j <= i; j++ {
				if tag == 1 {
					fmt.Print(string(myFile[j]))
				}

			}
			tag = 0

		}

	}
	myFile = myFile[0 : len(myFile)-1]
}

func cArgs(string1, string2, string3 string) {
	myFile, err := ioutil.ReadFile(string3)
	ifErrRead_grep(err != nil) //if it goes wrong, panic

	myFile = append(myFile, 03)

	switch string1 {
	case "-v":

		break
	case "-n":

		break
	default:
		log.Fatalln("\n" +
			"	El comando  " + string1 + "  no es válido." +
			"\n" +
			"grep [ -v | -n ] [patrón] <fileName>" +
			"\n	-v : grep -v hola pp.txt lista las líneas que no contengan la cadena hola del archivo pp.txt." +
			"\n	-n : grep -n hola pp.txt las líneas concordantes con la cadena hola del archivo pp.txt se mostrarán acompañadas del número de línea.")
		break
	}
}

func ifErrRead_grep(c bool) {
	if c {
		panic("Error al abrir el fichero, esto podria deberse a que no existe." +
			"\n" +
			"grep [ -v | -n ] [patrón] <fileName>" +
			"\n	-v : grep -v hola pp.txt lista las líneas que no contengan la cadena hola del archivo pp.txt." +
			"\n	-n : grep -n hola pp.txt las líneas concordantes con la cadena hola del archivo pp.txt se mostrarán acompañadas del número de línea.")
	}
}
