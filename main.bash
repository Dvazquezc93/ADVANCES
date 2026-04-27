#                             Online Bash Shell.
#                 Code, Compile, Run and Debug Bash script online.
# Write your code in this editor and press "Run" button to execute it.


read -p "dime el primer numero : " num1
read -p "dime el segundo numero : " num2
read -p "dime el tercer numero : " num3
suma=$((num1+num2+num3))
resultado=$(echo "scale=2 ; suma/3" | bc -l)
echo "su media es $resultado"