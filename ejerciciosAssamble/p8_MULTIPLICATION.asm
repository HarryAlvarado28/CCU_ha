.org 1000h

				MVI	A,05H
				STA	4150H

				MVI	A,03H
				STA	4151H

				;Primero cargamos los valores en la direcciones 4150H y 4151H

				MVI	D,00H		;Inicializa el registro D a 00.
				MVI	A,00H		;Inicializa el Acumulador con 00.
				LXI	H,4150H ;Carga la dirección 4150 en el registro HL.
				MOV	B,M			;Mueve el contenido de M(HL) al registro B.
				INX	H				;Incrementa el registro H y L.
				MOV	C,M			;Mueve el contenido de M(HL) al registro C.
LOOP:		ADD	B				;Suma el registro B al registro A (Acumulador).
				JNC	NEXT		;Salta a NEXT si no hay acarreo.
				INR	D				;Incrementa contenido del registro D.
NEXT:		DCR	C				;Decrementa contenido del registro C.
				JNZ	LOOP		;Salta a LOOP si no es cero.
				STA	4152H		;Almacena el valor (resultado) del acumulador en la dirección 4152.
				MOV	A,D			;Mueve el contenido del registro D al registro A (Acumulador).
				STA	4153		;Almacena el valor (MSB) del acumulador en la dirección (4153).
				HLT					;Detiene el programa.
