/*
fichero instrucciones.l
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
{identificador} {return (IDENTIFICADOR);}
"("             {return (APAR);}
")"             {return (CPAR);}
\n              {return (NL);}
.               ECHO;
%%
