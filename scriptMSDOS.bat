@echo off
::pause
::variables pre-definidas
set name_file_backup="backup.log"
set cont=0

set /p ori="Ruta origen: "
set /p dts="Ruta destino (opcional): "
set /p tt="Tiempo: "

echo "-----------------------------------------------------------------"
echo "Fecha exacta de inicio del backup: %date%-%time%"
echo "[Ruta origen: %ori%]"
echo "[Ruta destino: %dts%]"
echo "[Se respalda cada: %tt% segundo/s]"
echo "Datos almacenados en el archivo {%name_file_backup%}"
echo "-----------------------------------------------------------------"

echo . > %name_file_backup%

echo "-----------------------------------------------------------------" >> %name_file_backup%
echo "Fecha exacta de inicio del backup: %date%-%time%"                  >> %name_file_backup%
echo "[Ruta origen: %ori%]"                                              >> %name_file_backup%
echo "[Ruta destino: %dts%]"                                             >> %name_file_backup%
echo "[Se respalda cada: %tt% segundo/s]"                                >> %name_file_backup%
echo "-----------------------------------------------------------------" >> %name_file_backup%


::@pause
::set dts1=%chdir%/%%
::echo "Las copias estan es> %dts1%"
::@pause
mkdir %dts%/bkp
:loop

    timeout /t %tt%

    echo ".............................................................." >> %name_file_backup%
    echo ".............................................................."

    set /A cont = %cont% + 1

    set ruta=receta_%cont%_-%time%
    ::cd bkp
    mkdir %dts%/bkp/%ruta%
    ::echo bkp/%ruta%
    ::echo %ruta%
    copy %ori% %dts%/bkp/%ruta%

    echo fecha: %date% >> %name_file_backup%
    echo hora: %time%  >> %name_file_backup%

    echo "Respaldo # :%cont% " >> %name_file_backup%

    echo Time: %time%

    echo "         Copia realizada!!! %name_file_backup%"

    echo "Respaldo # %cont% "

    echo "Ruta:"
    chdir
    echo "Name: [%dts%/bkp/%ruta%]"

    echo "Ruta:"              >> %name_file_backup%
    chdir                     >> %name_file_backup%
    echo "Name: [%dts%/bkp/%ruta%]"     >> %name_file_backup%

    echo ".............................................................." >> %name_file_backup%
    echo ".............................................................."

goto loop

exit
