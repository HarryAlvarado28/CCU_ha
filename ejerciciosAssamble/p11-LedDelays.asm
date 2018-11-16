;LUZ COCHE FANTASTICO 
;
; requiere 	led en puerto 0
;		interrupcion rst 7.5 cada 1 segundo

.org 1000h

mvi c,128
mov d,0

salto:
mov a,c
out 0h
;jmp salto	;hay que quiatrle esto TAREA

;.org 003ch	;hay que quiatrle esto TAREA
;Subrutina cada 1 segundo
;powered by Harry Alvarado
sub:
mov a,d
cpi 0
jnz mub

mov a,c		;direccion -->
rar
mov c,a
mov a,c
cpi 0
jnz rub
mvi c,1
mvi d,1

mub:
mov a,c		;direccion <--
ral
mov c,a
mov a,c
cpi 0
jnz rub
mvi c,128
mvi d,0

rub:
;ei
;ret
		MVI	B,41H		; T-States
LOOP2:	MVI	E,41H		;7 T-States
LOOP1:	DCR	E		;7 T-States
		JNZ	LOOP1		; T-States
		DCR	B		;
		JNZ	LOOP2		;
JMP salto
;powered by Harry Alvarado