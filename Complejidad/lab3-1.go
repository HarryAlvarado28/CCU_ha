package main

import "fmt"

func main() {
	var_entrada := 5
	fmt.Printf("Result: %+v\n", funcion(var_entrada))
}

func funcion(n int) int {
	var sol = 0
	for i := 0; i < n; i++ {
		sol = sol + i
	}
	return sol
}
