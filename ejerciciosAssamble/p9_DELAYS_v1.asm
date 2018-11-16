.org 1000h
		
		MVI	B,82H		; T-States
LOOP2:	MVI	C,82H		;7 T-States
LOOP1:	DCR	C		;7 T-States
		JNZ	LOOP1		; T-States
		DCR	B		;
		JNZ	LOOP2		;
		HLT			

;OTHER
;
;
;