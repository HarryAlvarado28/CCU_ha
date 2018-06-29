#!/usr/bin/env bash

read -p "Ruta origen: " ori
read -p "Ruta destino: " dts
read -p "Tiempo: " tt

echo "Ruta de origen: $ori"
echo "Ruta de destino: $dts"
echo "tiempo: $tt"

cont=1
touch backup.log
echo "-$ori" >> backup.log
echo "-$dts" >> backup.log
echo "-$tt" >> backup.log
while true; do
    cont=$[$cont+1]
    ## cp -R "" ""
    date >> backup.log
    echo "Copia:$cont " >> backup.log
    sleep $tt
    date;
    echo "  ¡¡Copia realizada!!! backup.log : $cont"
done
