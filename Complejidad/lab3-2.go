package main

import (
	"fmt"
	"math"
)

func main() {
	var_entrada := 10.0
	fmt.Printf("Ultimo resultado: %+v\n", g(var_entrada))
}

// ALGORITMO B f(E N n)
func f(x float64) float64 {
	return (x - 5.0)
}

// ALGORITMO N g(E N n)
func g(x float64) float64 {
	return math.Pow(f(x), 2.0)
}
