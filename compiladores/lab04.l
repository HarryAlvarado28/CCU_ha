/*
fichero instrucciones.l
"print"         {return (PRI);}
*/
%{
#include <stdio.h>
#include "y.tab.h" /* GENERADO AUTOMÁTICAMENTE POR BISON */
%}
separador       ([ \t""])+
letra           [a-zA-Z]
digito          [0-9]
identificador   {letra}({letra}|{digito})*
constEntera     {digito}({digito})*
%%
{separador}     {/* omitir */}
{constEntera}   {return (CONSTENTERA);}
":="            {return (OPAS);}
"+"             {return (MAS);}
"-"             {return (MEN);}
"*"             {return (PROD);}
"**"            {return (POT);}
{identificador} {return (IDENTIFICADOR);}
"print("        {return (PRI);}
"("             {return (APAR);}
")"             {return (CPAR);}
"{"             {return (COR);}
"}"             {return (CORC);}
\n              {return (NL);}
.               ECHO;
%%
