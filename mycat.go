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
			"\n	-c : cantidad, muestra la cantidad de caracteres que contiene el archivo." +
			"\n	-n : enumeración, enumera las lineas del archivo." +
			"\n	-m : enumeración, esta enumeración ignora las lineas en blanco.")
	}
}

func onlyFile(string2 string) {
	myFile, err := ioutil.ReadFile(string2)
	ifErrRead_cat(err != nil) //if it goes wrong, panic
	fmt.Print("****Loque dice el archivo****:\n", string(myFile), "\n")
}

func withArgs(string1, string2 string) {
	myFile, err := ioutil.ReadFile(string2)
	ifErrRead_cat(err != nil) //if it goes wrong, panic

	switch string1 {
	case "-c":
		fmt.Println("\n\tLa cantidad de caracteres que contiene el archivo es: ", len(myFile), " \n")
		break
	case "-n":
		myFile = append(myFile, 03)

		n, j := 0, 0
		for i := 0; i < len(myFile); i++ {
			if myFile[i] == byte(10) || myFile[i] == byte(03) {
				n += 1
				fmt.Print(" ", n, "  ")
				for ; j <= i; j++ {
					fmt.Print(string(myFile[j]))
				}
			}
		}
		myFile = myFile[0 : len(myFile)-1]
		fmt.Println()
		break
	case "-m":
		myFile = append(myFile, 03)

		n, j := 0, 0
		for i := 0; i < len(myFile); i++ {
			if myFile[i] == byte(10) && myFile[i+1] != byte(10) {
				n += 1
				fmt.Print(" ", n, "  ")
				for ; j <= i; j++ {
					fmt.Print(string(myFile[j]))
				}
			}
		}
		myFile = myFile[0 : len(myFile)-2]
		fmt.Println()
		break
	default:
		log.Fatalln("\n" +
			"	El comando  " + string1 + "  no es válido." +
			"\n" +
			"cat [ -c | -n | -m ] <fileName>" +
			"\n	-c : cantidad, muestra la cantidad de caracteres que contiene el archivo." +
			"\n	-n : enumeración, enumera las lineas del archivo." +
			"\n	-m : enumeración, esta enumeración ignora las lineas en blanco.")
		break
	}
}

func ifErrRead_cat(c bool) {
	if c {
		panic("Error al abrir el fichero, esto podria deberse a que no existe." +
			"\n" +
			"cat [ -c | -n | -m ] <fileName>" +
			"\n	-c : cantidad, muestra la cantidad de caracteres que contiene el archivo." +
			"\n	-n : enumeración, enumera las lineas del archivo." +
			"\n	-m : enumeración, esta enumeración ignora las lineas en blanco.")
	}
}
