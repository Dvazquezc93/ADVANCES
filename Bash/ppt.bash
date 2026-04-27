#                             Online Bash Shell.
#                 Code, Compile, Run and Debug Bash script online.
# Write your code in this editor and press "Run" button to execute it.
function echolor() 
{ 
    COLORECHO="0;37m" #blanco 
    TEXTOECHO=$2 
    if [ $1 = "rojo" ];then COLORECHO="1;31m" ; fi 
    if [ $1 = "verde" ];then COLORECHO="1;32m" ; fi 
    if [ $1 = "amarillo" ];then COLORECHO="1;33m" ; fi 
    if [ $1 = "azul" ];then COLORECHO="1;34m" ; fi 
    if [ $1 = "morado" ];then COLORECHO="1;35m" ; fi 
    if [ $1 = "cyan" ];then COLORECHO="1;36m" ; fi 
    echo -e "\033[$COLORECHO$2\033[0m" 
}

finish="Si"

while [ "$finish" = "Si" ]; do
echolor "amarillo" "Piedra, Papel, Tijera... un, dos, tres... ya " 
read var1
NUM=$((RANDOM % 3))
if [ $NUM -eq 1 ] && [ "$var1" = "Piedra" ]; then
echolor "azul" " Piedra, empate, de nuevo."
elif [ $NUM -eq 2 ] && [ "$var1" = "Piedra" ]; then
echolor "rojo" " Papel, perdiste ¿una mas?" 
read finish
elif [ $NUM -eq 3 ] && [ "$var1" = "Piedra" ]; then
echolor "verde" " Tijeras, ganaste ¿una mas?"
read finish
elif [ $NUM -eq 2 ] && [ "$var1" = "Papel" ]; then
echolor "azul" " Papel, empate, de nuevo."
elif [ $NUM -eq 3 ] && [ "$var1" = "Papel" ]; then
echolor "rojo" "Tijeras, perdiste ¿una mas?"
read finish
elif [ $NUM -eq 1 ] && [ "$var1" = "Papel" ]; then
echolor "verde" " Piedra, ganaste ¿una mas?"
read finish
elif [ $NUM -eq 3 ] && [ "$var1" = "Tijeras" ]; then
echolor "azul" " Tijeras, empate, de nuevo."
elif [ $NUM -eq 1 ] && [ "$var1" = "Tijeras" ]; then
echolor "rojo" "Piedra, perdiste ¿una mas?" 
read finish
elif [ $NUM -eq 2 ] && [ "$var1" = "Tijeras" ]; then
echolor "verde" " Papel, ganaste ¿una mas?" 
read finish
fi
done
