#!/usr/bin/env bash

##variables pre-definidas
name_dir_backrest="backupSave_fun"
name_file_backrest="backup.log"
cont=0
tt=60

echo "[FUN, ruta para realizar el respaldo]"
echo "[Tiempo, cada que tiempo se desea hacer la copia, opcional (el valor por defecto es 60s)]"

read -p "FUN: " fun
read -p "Tiempo: " tt

echo "-----------------------------------------------------------------"
echo "Fecha exacta de inicio del backup: `date`"
echo "[FUN: $fun]"
echo "[Se respalda cada: $tt segundo/s]"
echo "Datos almacenados en el archivo {${name_file_backrest}}"
echo "-----------------------------------------------------------------"

touch ${name_file_backrest}
echo "-----------------------------------------------------------------" >> ${name_file_backrest}
echo "Fecha exacta de inicio del backup: `date`"                         >> ${name_file_backrest}
echo "[FUN: $fun]"                                                       >> ${name_file_backrest}
echo "[Se respalda cada: $tt segundo/s]"                                 >> ${name_file_backrest}
echo "-----------------------------------------------------------------" >> ${name_file_backrest}

echo "Las copias están es> `pwd`/"${name_dir_backrest}

while true; do
    sleep ${tt}
    echo ".............................................................." >> ${name_file_backrest}
    echo ".............................................................."
    cont=$[$cont+1]
    ruta=${name_dir_backrest}"/receta_"${cont}"_`date +%B_%d-%H_%M_%S`"
    mkdir -p ${ruta}
    cp -R ${fun} ${ruta}
    date >> ${name_file_backrest}
    echo "Respaldo # :$cont " >> ${name_file_backrest}
    date;
    echo "          ¡¡Copia realizada!!! ${name_file_backrest}"
    echo "Respaldo # $cont "
    echo "Ruta: [`pwd`/$ruta]"
    echo "Ruta: [`pwd`/$ruta]" >> ${name_file_backrest}
    echo ".............................................................." >> ${name_file_backrest}
    echo ".............................................................."
done
