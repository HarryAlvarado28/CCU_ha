%{
/* fichero instrucciones.y */
#include <stdio.h>
%}
%token IDENTIFICADOR NL OPAS CONSTENTERA CONSTDECIMAL MAS MEN PROD POT APAR CPAR COR CORC PRI LEE COMO COMC
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
            | COMO loquesea COMC NL
            ;
expresion : termino
          | expresion MAS termino
          | expresion MEN termino
          | expresion PROD termino
          | expresion POT termino
          ;
termino : IDENTIFICADOR
        | CONSTENTERA
        | CONSTDECIMAL
        | APAR expresion CPAR
        | COR expresion CORC
        | IDENTIFICADOR termino
        ;

%%
yyerror (s)
    char *s;
{
  extern int yylineno;
  printf (" in line :%d\n", yylineno);
  printf ("Buajaja, esta mal!: %s\n", s);
  exit(-1);
}

int main()
{
  printf ("Antes del yyparse()\n");
  yyparse();
  return 0;
}
