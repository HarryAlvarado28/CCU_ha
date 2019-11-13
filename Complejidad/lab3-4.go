package main

import "fmt"

func main() {
	var_entrada := 10
	fmt.Printf("Fun: %+v\n", f_(var_entrada))
}

// ALGORITMO Z f(E Z x)
func f_(x int) int {
	var result int
	if x > 100 {
		result = x - 10
	} else {
		a := f_(x + 11)
		result = f_(a)
	}
	return result
}
