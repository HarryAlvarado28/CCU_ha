.org 1000h

				MVI	A,06H
				STA	4150H

				MVI	A,03H
				STA	4151H

				;Primero cargamos los valores en la direcciones 4150H y 4151H

				LXI	H,4150H		;Carga la dirección de 4150 en el registro HL.
				MOV	B,M				;Mueve contenido de M(HL) al registro B.
				MVI	C,00H			;Mueve el valor 00 al registro C.
				INX	H					;Incrementa el registro H.
				MOV	A,M				;Mueve el contenido de M(HL) al registro A.
NEXT:		CMP	B					;Compara el registro B con el registro A (Acumulador).
				JC	LOOP			;Ir a LOOP si hay acarreo.
				SUB	B					;Resta el registro B del registro A (Acumulador).
				INR	C					;Incrementa contenido del registro C.
				JMP	NEXT			;Salta incondicionalmente a la dirección NEXT.
LOOP:		STA	4152H			;Almacena el valor del acumulador en la dirección (4152).
				MOV	A,C				;Mueve el contenido del registro C al registro A (Acumulador).
				STA	4153H			;Almacena el valor del acumulador en la dirección 4153.
				HLT						;Detiene el programa.
