package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
)

func main() {
	var a string

	if len(os.Args) == 2 {
		a = os.Args[1]
		onlyFile(a)
	} else if len(os.Args) == 3 {
		a = os.Args[1]
		b := os.Args[2]
		withArgs(a, b)
	} else {
		log.Fatalln("\n" +
			"cat [ -c | -n ] <fileName>" +
			"\n	-c : cantidad, muestra la cantidad de caracteres que contiene el archivo" +
			"\n	-n : enumeración, enumera las lineas del archivo")
	}
}

func onlyFile(string2 string) {
	myFile, err := ioutil.ReadFile(string2)
	if err != nil {
		panic("Error al abrir el fichero, esto podria deberse a que no existe u otro pograma lo esta utilizando." +
			"\n" +
			"cat [ -c | -n ] <fileName>" +
			"\n	-c : cantidad, muestra la cantidad de caracteres que contiene el archivo" +
			"\n	-n : enumeración, enumera las lineas del archivo")

	}
	fmt.Print("****Loque dice el archivo****:\n", string(myFile), "\n")
}

func withArgs(string1, string2 string) {
	myFile, err := ioutil.ReadFile(string2)
	if err != nil {
		panic("Error al abrir el fichero, esto podria deberse a que no existe u otro pograma lo esta utilizando." +
			"\n" +
			"cat [ -c | -n ] <fileName>" +
			"\n	-c : cantidad, muestra la cantidad de caracteres que contiene el archivo" +
			"\n	-n : enumeración, enumera las lineas del archivo")
	}
	switch string1 {
	case "-c":
		fmt.Println("cantidad de caracteres que contiene el archivo: ", len(myFile))
		break
	case "-n":
		n, j := 0, 0
		for i := 0; i < len(myFile); i++ {
			if myFile[i] == byte(10) {
				n += 1
				fmt.Print(" ", n, "  ")
				for ; j <= i; j++ {
					fmt.Printf("%s", string(myFile[j]))
				}
			}
		}
		break
	}
}
