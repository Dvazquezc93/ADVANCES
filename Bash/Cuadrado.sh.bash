#                             Online Bash Shell.
#                 Code, Compile, Run and Debug Bash script online.
# Write your code in this editor and press "Run" button to execute it.


read -p "Dame un numero mayor que 0 :" limite

for (( fila=1; fila<=limite; fila++ )); do
    for (( Columnas=1;Columnas<=limite; Columnas++ )); do
    if [ "$fila" -eq "$Columnas" ] ||  [ $((fila + Columnas)) -eq $(( limite + 1 )) ]; then
            echo -n "*"
    else
            echo -n "-"
    fi
    done
    echo ""
done

