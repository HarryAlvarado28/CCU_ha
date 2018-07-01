#!/usr/bin/env bash

##variables pre-definidas
name_file_backup="backup.log"
cont=0

read -p "Ruta origen: " ori
read -p "Ruta destino (opcional): " dts
read -p "Tiempo: " tt

echo "-----------------------------------------------------------------"
echo "Fecha exacta de inicio del backup: `date`"
echo "[Ruta origen: $ori]"
echo "[Ruta destino: $dts]"
echo "[Se respalda cada: $tt segundo/s]"
echo "Datos almacenados en el archivo {${name_file_backup}}"
echo "-----------------------------------------------------------------"

touch ${name_file_backup}
echo "-----------------------------------------------------------------" >> ${name_file_backup}
echo "Fecha exacta de inicio del backup: `date`"                         >> ${name_file_backup}
echo "[Ruta origen: $ori]"                                               >> ${name_file_backup}
echo "[Ruta destino: $dts]"                                              >> ${name_file_backup}
echo "[Se respalda cada: $tt segundo/s]"                                 >> ${name_file_backup}
echo "-----------------------------------------------------------------" >> ${name_file_backup}

dts1=`pwd`"/"${dts}"/bkp"
echo "Las copias están es>" ${dts1}

while true; do
    sleep ${tt}
    echo ".............................................................." >> ${name_file_backup}
    echo ".............................................................."
    cont=$[$cont+1]
    ruta=${dts1}"/receta_"${cont}"_`date +%B_%d-%H_%M_%S`"
    mkdir -p ${ruta}
    cp -R ${ori} ${ruta}
    date >> ${name_file_backup}
    echo "Respaldo # :$cont " >> ${name_file_backup}
    date;
    echo "          ¡¡Copia realizada!!! ${name_file_backup}"
    echo "Respaldo # $cont "
    echo "Ruta: [$ruta]"
    echo "Ruta: [$ruta]" >> ${name_file_backup}
    echo ".............................................................." >> ${name_file_backup}
    echo ".............................................................."
done
