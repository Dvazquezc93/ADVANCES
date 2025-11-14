package ejercicios.Ejercicio15;

import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio15 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);

		System.out.println("Dime un numero: ");
		Integer n = skynnet.nextInt();
		for (Integer n2=0, n3=0; n3 != 11; n2=n*n3) {

			System.out.println(n + "x" + n3 + "=" + n2);
			n3++;

		}
		skynnet.close();
	}

}
