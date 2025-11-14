package ejercicios.EjercicioR07;

import java.util.Iterator;
import java.util.Scanner;

public class EjercicioR07 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);

		Integer numero1, multiplo, suma, total = 0;
		do {
			System.out.println("Dime un número: ");
			numero1 = skynnet.nextInt();
			if (numero1 <= 10 && numero1 >= 1) {
				for (multiplo = 1; multiplo <= 10; multiplo++) {
					suma = numero1 * multiplo;
					total = total + suma;

					if (multiplo == 10) {
						System.out.println(suma + "=" + total);

					} else if (multiplo != 10) {
						System.out.print(suma + "+");
					}
				}
			}
			if (numero1 > 10 || numero1 < 0) {
				System.out.println("error.");
			}
		} while (numero1 != 0);

		System.out.println("bye bye");
		skynnet.close();

	}

}
