package ejercicios.Ejercicio08;

import java.util.Scanner;

public class Ejercicio08 {
	public static void main(String[] args) {

		Scanner skynnet = new Scanner(System.in);
		String palabra1, palabra2;

		do {
			System.out.println("Dime una palabra :");
			palabra1 = skynnet.nextLine();
			System.out.println("Dime otra palabra:");
			palabra2 = skynnet.nextLine();

		} while (!palabra1.equalsIgnoreCase(palabra2));

		System.out.println("Esa es la palabra magica.");
		skynnet.close();
	}

}
