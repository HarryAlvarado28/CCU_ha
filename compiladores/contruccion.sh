#!/bin/bash
#ejecutando instrucciones

bison -yd lab04.y

flex lab04.l

gcc y.tab.c lex.yy.c -ll -o sal_test
