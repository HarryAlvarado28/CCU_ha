%{
/* fichero instrucciones.y */
#include <stdio.h>
%}
%token IDENTIFICADOR OPAS CONSTENTERA NL MAS APAR CPAR
%start instrucciones
%%
instrucciones : instrucciones instruccion
              | instruccion
              ;
instruccion : IDENTIFICADOR OPAS expresion NL
            ;
expresion : termino
          | expresion MAS termino
          ;
termino : IDENTIFICADOR
        | CONSTENTERA
        | APAR expresion CPAR
        ;
%%
yyerror (s)
    char *s;
{
    printf ("%s\n", s);
}

int main()
{
  yyparse();
  return 0;
}
