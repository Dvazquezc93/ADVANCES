package ejercicios.Ejercicio05;

import java.util.Scanner;

public class Ejercicio05 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("muestras todos los numeros del 1 al 10000");
		Integer suma = 0;
		Integer num = 0;
		do {
			num++; //num=num+1
			System.out.println(num);
			suma += num;//suma=suma+sum

		} while (num < 10000);
		System.out.println(suma);
		skynnet.close();
	}

}
