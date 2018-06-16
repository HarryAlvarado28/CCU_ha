package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
)

func main() {
	a := ""

	if len(os.Args) == 2 {
		a = os.Args[1]
		onlyFile(a)
	} else if len(os.Args) == 3 {
		a = os.Args[1]
		b := os.Args[2]
		withArgs(a, b)
	} else {
		log.Fatalln("\n" +
			"cat [ -n | -size ] <fileName>" +
			"\n	-t : conteo de caracteres" +
			"\n	-n : numeración de lineas")
	}
}

func onlyFile(string2 string) {
	myFile, err := ioutil.ReadFile(string2)
	if err != nil {
		panic("Error al abrir el fichero, esto podria deberse a que no existe u otro pograma lo esta utilizando.")
	}
	fmt.Print("****Loque dice el archivo****:\n", string(myFile), "\n")
}

func withArgs(string1, string2 string) {
	myFile, err := ioutil.ReadFile(string2)
	if err != nil {
		panic("Error al abrir el fichero, esto podria deberse a que no existe u otro pograma lo esta utilizando.")
	}
	switch string1 {
	case "-t":
		fmt.Println("cantidad de caracteres que contiene el archivo: ", len(myFile))
		break
	case "-n":
		for i := 0; i < len(myFile); i++ {
			if myFile[i] == byte(10) {
				myFile[i] = byte(119)
			}
		}
		fmt.Print(string(myFile))
		break
	}
}
