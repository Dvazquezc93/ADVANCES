package ejercicios.Ejercicio07;

import java.util.Scanner;

public class Ejercicio07 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Integer n1, n2;
		do {
			System.out.println("Dime un numero:");
			n1 = skynnet.nextInt();
			System.out.println("Dime otro numero:");
			n2 = skynnet.nextInt();

		} while (n1!= n2);

		System.out.println("Ese es el numero magico.");
		skynnet.close();
	}

}
