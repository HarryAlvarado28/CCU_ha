.org 1000h

				MVI	A,05H
				STA	4150H

				MVI	A,04H
				STA	4151H

				;Primero cargamos los valores en la direcciones 4150H y 4151H

				MOV	C,00H  ;Inicializa el registro C a 00.
				LDA	4150H	 ;Carga el valor (de la dirección 4150) al Acumulador.
				MOV	B,A		 ;Mueve el contenido del acumulador al registro B.
				LDA	4151H	 ;Carga el valor (de la dirección 4151) al Acumulador.
				ADD	B			 ;Agrega el valor B a A (acumulador).
				JNC	LOOP   ;Salta si no hay acarreo.
				INR	C			 ;Incrementa el valor del registro C.
LOOP:		STA	4152H	 ;Almacena el valor del acumulador en la direccion (4152).
				MOV	A,C    ;Mueve el contenido de C al acumulador.
				STA	4153H  ;Almacena el valor del acumulador.
				HLT				 ;Detiene el programa.
