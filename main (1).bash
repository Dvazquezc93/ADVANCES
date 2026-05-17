#                             Online Bash Shell.
#                 Code, Compile, Run and Debug Bash script online.
# Write your code in this editor and press "Run" button to execute it.

while true; do
read -p "dime un numero mayor que cero : " num1
if [ $num1 -ne 0 ]; then
break
fi
done
contador=0
for ((num2=num1;num2>1;num2--)); do
if  (( num2%2==1)); then
let contador=contador+1 
fi
done
echo "Tu número tiene $contador impares"