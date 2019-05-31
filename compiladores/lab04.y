%{
/* fichero instrucciones.y */
#include <stdio.h>
%}
%token IDENTIFICADOR NL OPAS CONSTENTERA MAS MEN PROD POT APAR CPAR COR CORC PRI LEE
%start instrucciones
%%
instrucciones : instrucciones instruccion
              | instruccion
              ;
loquesea : expresion
         | termino
         ;
instruccion : PRI loquesea CPAR NL
            | LEE loquesea CPAR NL
            ;
expresion : termino
          | expresion MAS termino
          | expresion MEN termino
          | expresion PROD termino
          | expresion POT termino
          ;
termino : IDENTIFICADOR
        | CONSTENTERA
        | APAR expresion CPAR
        | COR expresion CORC
        | IDENTIFICADOR termino
        ;
%%
yyerror (s)
    char *s;
{
    printf ("Buajaja, esta mal!: %s\n", s);
}

int main()
{
  printf ("Antes del yyparse()\n");
  yyparse();
  return 0;
}
