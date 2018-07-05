@echo off

::variables pre-definidas
set name_dir_backrest=backupSave_fun
set name_file_backrest=backup.log
set cont=0
set tt=60

echo [FUN, ruta para realizar el respaldo]
echo [Tiempo, cada que tiempo se desea hacer la copia, opcional (el valor por defecto es 60s)]

set /p fun=FUN:
set /p tt=Tiempo:

echo -----------------------------------------------------------------
echo Fecha exacta de inicio del backup: %date%-%time%
echo [FUN: %fun%]
echo [Se respalda cada: %tt% segundo/s]
echo Datos almacenados en el archivo {%name_file_backrest%}
echo -----------------------------------------------------------------

echo . > %name_file_backrest%

echo ----------------------------------------------------------------- >> %name_file_backrest%
echo    Fecha exacta de inicio del backup: %date%-%time%>> %name_file_backrest%
echo    [FUN: %fun%]>> %name_file_backrest%
echo    [Se respalda cada: %tt% segundo/s]>> %name_file_backrest%
echo ----------------------------------------------------------------- >> %name_file_backrest%

mkdir %name_dir_backrest%
cd %name_dir_backrest%
:loop

    timeout /t %tt%
    ::echo .............................................................. >> %name_file_backrest%
    ::echo ..............................................................

    set /A cont = %cont% + 1
    set ruta=receta_%cont%

    mkdir %ruta%
    copy %fun% %ruta%

    cd ..
      echo fecha: %date%>> %name_file_backrest%
      echo hora: %time%>> %name_file_backrest%
      echo    Respaldo # :%cont%>> %name_file_backrest%
    cd %name_dir_backrest%
      echo Time: %time%
      echo          Copia realizada!!! %name_file_backrest%
      echo          Respaldo # %cont%
      echo Ruta base:
        chdir
      echo Nombre del directorio: [%ruta%]
    cd ..
      echo Ruta base:>> %name_file_backrest%
    chdir >> %name_file_backrest%
      echo Nombre del directorio: [%ruta%]>> %name_file_backrest%
      echo .............................................................. >> %name_file_backrest%
      echo ..............................................................
    cd %name_dir_backrest%
goto loop
