#                             Online Bash Shell.
#                 Code, Compile, Run and Debug Bash script online.
# Write your code in this editor and press "Run" button to execute it.

finish="Si"

while [ "$finish" = "Si" ]; do
echo "Piedra, Papel, Tijera... un, dos, tres... ya " 
read var1
NUM=$((RANDOM % 3))
if [ $NUM -eq 1 ] && [ "$var1" = "Piedra" ]; then
echo " Piedra, empate, de nuevo."
elif [ $NUM -eq 2 ] && [ "$var1" = "Piedra" ]; then
echo  " Papel, perdiste ¿una mas?" 
read finish
elif [ $NUM -eq 3 ] && [ "$var1" = "Piedra" ]; then
echo  " Tijeras, ganaste ¿una mas?"
read finish
elif [ $NUM -eq 2 ] && [ "$var1" = "Papel" ]; then
echo " Papel, empate, de nuevo."
elif [ $NUM -eq 3 ] && [ "$var1" = "Papel" ]; then
echo  "Tijeras, perdiste ¿una mas?"
read finish
elif [ $NUM -eq 1 ] && [ "$var1" = "Papel" ]; then
echo  " Piedra, ganaste ¿una mas?"
read finish
elif [ $NUM -eq 3 ] && [ "$var1" = "Tijeras" ]; then
echo " Tijeras, empate, de nuevo."
elif [ $NUM -eq 1 ] && [ "$var1" = "Tijeras" ]; then
echo  "Piedra, perdiste ¿una mas?" 
read finish
elif [ $NUM -eq 2 ] && [ "$var1" = "Tijeras" ]; then
echo  " Papel, ganaste ¿una mas?" 
read finish
fi
done
