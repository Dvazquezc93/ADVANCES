package ejercicios.EjercicioR17;

import java.util.Scanner;

public class EjercicioR17 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Integer numero1 = 0, total1, suma1 = 0;
		do {

			System.out.println("Dime un número mayor de dos:");
			numero1 = skynnet.nextInt();

			if (numero1 <= 2) {
				System.out.println("error");
			}

		} while (numero1 <= 2);
		suma1 = numero1 + (numero1 + 1);
		System.out.print(numero1 + ", " + suma1 + ", ");
		for (Integer v1 = 0; v1 <= 11; v1++) {

			total1 = numero1 + suma1;
			if (v1 == 11) {
				System.out.print(" y " + total1 + ". ");
			} else if (v1 < 10) {
				System.out.print(total1 + ", ");
			} else if (v1 == 10) {
				System.out.print(total1);
			}

			numero1 = suma1;
			suma1 = total1;

		}
		skynnet.close();
	}
}
