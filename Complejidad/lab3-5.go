package main

import "fmt"

func main() {
	var_m := 1.0
	var_n := 2.0
	r, c := Ackermann(var_m, var_n, 1)
	fmt.Println("Result: ", r, " cantidad: ", c)
}

// ALGORITMO Z p(E Z x)
func Ackermann(m float64, n float64, c int) (float64, int) {
	count := 0
	count += c
	fmt.Println("- ", count)
	if m == 0.0 {
		count += c
		return n + 1, count
	} else if m > 0.0 && n == 0 {
		count += c
		return Ackermann(m-1.0, 1.0, count)
	} else {
		count += c
		f, c_sub := Ackermann(m, n-1.0, count)
		return Ackermann(m-1.0, f, c_sub)
	}
}
