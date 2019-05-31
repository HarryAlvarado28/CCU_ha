/*
fichero instrucciones.l
"print"         {return (PRI);}
*/
%{
#include <stdio.h>
#include "y.tab.h" /* GENERADO AUTOMÁTICAMENTE POR BISON */
%}
%option yylineno
separador       ([ \t""])+
letra           [a-zA-Z]
digito          [0-9]
decimal         [0.0-9.9]
identificador   {letra}({letra}|{digito})*
constEntera     {digito}({digito})*
constDecimal    {decimal}({decimal})*
%%
{separador}     {/* omitir */}
{constEntera}   {return (CONSTENTERA);}
{constDecimal}  {return (CONSTDECIMAL);}
":="            {return (OPAS);}
"+"             {return (MAS);}
"-"             {return (MEN);}
"*"             {return (PROD);}
"**"            {return (POT);}
{identificador} {return (IDENTIFICADOR);}
"escribir("     {return (PRI);}
"leer("         {return (LEE);}
"/*"            {return (COMO);}
"*/"            {return (COMC);}
"("             {return (APAR);}
")"             {return (CPAR);}
"{"             {return (COR);}
"}"             {return (CORC);}
\n              {return (NL);}
.               ECHO;
%%
