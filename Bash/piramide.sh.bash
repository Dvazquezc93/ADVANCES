#                             Online Bash Shell.
#                 Code, Compile, Run and Debug Bash script online.
# Write your code in this editor and press "Run" button to execute it.


limite=5

for (( fila=1; fila<=limite; fila++ )); do
    for (( Columnas=1; Columnas<=fila; Columnas++ )); do
        if [ "$fila" -eq "$Columnas" ]; then
            echo -n "*"
        else
            echo -n "-"
        fi
    done
    echo ""
done

