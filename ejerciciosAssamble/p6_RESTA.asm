.org 1000h
				MVI	A,06H
				STA	4150H

				MVI	A,02H
				STA	4151H

				;Primero cargamos los valores en la direcciones 4150H y 4151H

				MOV	C,00H		;Inicializa el registro C a 00.
				LDA	4150H		;Carga el valor (de la dirección 4150) al Acumulador.
				MOV	B,A			;Mueve el valor del Acumulador al registro B.
				LDA	4151H		;Carga el valor (de la dirección 4151) al Acumulador.
				SUB	B				;Resta el valor del registro B del Acumulador.
				JNC	LOOP		;Salta si no hay acarreo.
				CMA					;Complemento del acumulador.
				INR	A				;Incrementa el valor en Acumulador.
				INR	C				;Incrementa el valor en registro C.
LOOP:		STA	4152H		;Almacena el valor (de la dirección 4152) en el Acumulador.
				MOV	A,C			;Mueve el contenido (valor) del registro C al Acumulador.
				STA	4153H		;Almacena el valor del acumulador en la dirección 4153.
				HLT					;Detiene el programa.
