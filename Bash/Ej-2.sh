#!/bin/bash
suma(){
sum=$(($1+$2))
return "$sum"
}
read -p "Ingresa un número: " NUM1
read -p "Ingresa un segundo número: " NUM2
suma "$NUM1" "$NUM2"
echo "El resultado es : suma() " 