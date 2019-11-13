package main

import "fmt"

func main() {
	var_entrada := 7
	r, c := p(var_entrada, 1)
	fmt.Println("Result: ", r, " cantidad: ", c)
}

// ALGORITMO Z p(E Z x)
func p(x int, count int) (int, int) {
	var result int
	var a, b, p1, p2, count_out int
	if x < 3 {
		result = x
		count_out += count
	} else {
		p1, a = p(x-1, count)
		p2, b = p(x-3, count)
		result = p1 * p2
		count_out = a + b
	}
	return result, count_out
}
