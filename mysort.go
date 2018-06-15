package main

import (
	"fmt"
	"log"
	"os"
)

func main() {
	fmt.Println(len(os.Args))
	if len(os.Args) < 2 {
		log.Fatalln("\n" +
			"sort [-i] <fileName>" +
			"\n	-i : ordena de forma inversa")
	}
	opc := os.Args[1]

	f, err := os.Open(opc)
	if err != nil {
		panic("El archivo no existe")
	}
	defer f.Close()
	fmt.Println(f)

	bs := make([]byte, 5)

	fmt.Println(bs)
}
