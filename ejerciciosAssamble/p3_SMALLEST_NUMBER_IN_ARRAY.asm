.org 1000h

		MVI	A,05H
		STA	4200H

		MVI	A,16H
		STA	4201H

		MVI	A,03H
		STA	4202H

		MVI	A,45H
		STA	4203H

		MVI	A,70H
		STA	4204H

		MVI	A,25H
		STA	4205H
	
		LXI	H,4200H
		MOV	B,M
		INX	H
		MOV	A,M
		DCR	B
LOOP:		INX	H
		CMP	M
		JC	AHEAD
		MOV	A,M
AHEAD:	DCR	B
		JNZ	LOOP
		STA	4207H
		HLT	