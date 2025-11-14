package ejercicios.Ejercicio16;

import java.util.Iterator;
import java.util.Scanner;

import ejercicios.Ejercicio15.Ejercicio15;

public class Ejercicio16 extends Ejercicio15 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("muestras todos los numeros del 1 al 10000");
		for (Integer suma= 0,num = 0; num<10001 ; num++) {
			System.out.println(num);
			suma += num;
			System.out.println(suma);
			}
		skynnet.close();

	}

}
