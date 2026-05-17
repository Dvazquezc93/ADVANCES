#                             Online Bash Shell.
#                 Code, Compile, Run and Debug Bash script online.
# Write your code in this editor and press "Run" button to execute it.

read -p "Dime un año : " num1

if [ $((num1 % 4)) -eq 0 ]; then
echo "Su año es bisiesto"
else
echo "Su año no es bisiesto"
fi
