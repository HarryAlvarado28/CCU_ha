package main

import (
	"fmt"
	"io/ioutil"
)

func main() {

	myFile, err := ioutil.ReadFile("fichero.txt")
	if err != nil {
		panic("Error al abrir el fichero, esto podria deberse a que no existe u otro pograma lo esta utilizando.")
	}
	fmt.Println(err) // si existe algun error entonces muestralo
	fmt.Println("Loque dice mi firecho:\n", string(myFile), "\n")
	fmt.Println("Tamaño: ", len(myFile))

	for i := 0; i < len(myFile); i++ {
		//fmt.Println(string(myFile[i:i+3]))
		keyword(string(myFile[i : i+3])) // para: int y var
		keyword(string(myFile[i : i+6])) // para: double y string
		simbolos(string(myFile[i]))      // para: simbolos
		numeros(string(myFile[i]))       // para: numeros

	}

}

func keyword(kword string) {
	p := "Estas imprimientdo un "

	switch kword {
	case "int":
		fmt.Println(p + "entero")
		break
	case "string":
		fmt.Println(p + "string")
		break
	case "double":
		fmt.Println(p + "double")
		break
	case "var":
		fmt.Println(p + "var")
		break
	default:
		//fmt.Println("Ninguna de los anteriores")
		break
	}
}

func simbolos(simb string) {
	p := "Simbolo encontrado "
	switch simb {
	case ";":
		fmt.Println(p + ";")
		break
	case "\"":
		fmt.Println(p + "\"")
		break
	case ":":
		fmt.Println(p + ":")
		break
	case "=":
		fmt.Println(p + "=")
		break
	case "{":
		fmt.Println(p + "{")
		break
	case "}":
		fmt.Println(p + "}")
		break
	default:
		//fmt.Println("Ninguna de los anteriores")
		break
	}
}

func numeros(n string) {
	p := "Numero encontrado "
	switch n {
	case "1":
		fmt.Println(p + "1")
		break
	case "2":
		fmt.Println(p + "2")
		break
	case "3":
		fmt.Println(p + "3")
		break
	case "4":
		fmt.Println(p + "4")
		break
	case "5":
		fmt.Println(p + "5")
		break
	case "6":
		fmt.Println(p + "6")
		break
	case "7":
		fmt.Println(p + "7")
		break
	case "8":
		fmt.Println(p + "8")
		break
	case "9":
		fmt.Println(p + "9")
		break
	case "0":
		fmt.Println(p + "0")
		break
	default:
		//fmt.Println("Ninguna de los anteriores")
		break
	}
}
