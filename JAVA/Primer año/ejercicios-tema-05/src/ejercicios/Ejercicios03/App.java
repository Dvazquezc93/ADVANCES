package ejercicios.Ejercicios03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer numero = 0, posicion = 0;
		SacoNumero saco = new SacoNumero();
		try {

			do {
				try {
					System.out.println("Dime un número:");
					numero = sc.nextInt();
					saco.addNumero(numero);
				} catch (InputMismatchException e) {
					System.out.println("ERROR CALVOS NO ENTRAN");
					sc.nextLine();
				}

			} while (numero != -1);
			System.out.println("Su lista es:" + saco);
			do {
				try {
					System.out.print("Dime la posición de un número: ");
					System.out.println("Su número es "+saco.getNumero(sc.nextInt()));
				} catch (InputMismatchException e) {
					System.out.println("La posición de su número no existe");
				}

			} while (posicion!=-1);

		} finally {
			sc.close();
		}

	}

}
