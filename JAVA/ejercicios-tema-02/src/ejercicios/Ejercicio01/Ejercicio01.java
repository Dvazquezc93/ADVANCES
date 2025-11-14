package ejercicios.Ejercicio01;

import java.util.Scanner;

public class Ejercicio01 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("¿De que año eres?");
		Integer año = skynnet.nextInt();

		if (año <= 1900) {
			System.out.println("Eres de la generacion perdida.");
		}
		else if (año <= 1927) {
			System.out.println("Eres de la generacion grandiosa.");
		}
		else if (año <=1945) {
			System.out.println("Eres de la generacion Silenciosa.");
		}
		else if (año <=1945) {
			System.out.println("Eres de la generacion Silenciosa.");
		}
		else if (año <=1964) {
			System.out.println("Eres de la generacion Baby Boomers.");
		}
		else if (año <=1980) {
			System.out.println("Eres de la generacion X.");
		}
		else if (año <=1980) {
			System.out.println("Eres de la generacion X.");
		}
		else if (año <=1996) {
			System.out.println("Eres de la generacion Y.");
		}
		else if (año <=2012) {
			System.out.println("Eres de la generacion Z.");
		}
		else if (año <=2025) {
			System.out.println("Eres de la generacion alfa.");
		}
		skynnet.close();
	}
}
