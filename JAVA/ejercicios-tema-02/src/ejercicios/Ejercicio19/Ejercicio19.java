package ejercicios.Ejercicio19;

import java.util.Iterator;

public class Ejercicio19 {

	public static void main(String[] args) {
		Integer limite = 9;

		for (Integer fila = 1; fila <= limite; fila++) {
			for (Integer numero = 1; numero <= fila; numero++) {
				System.out.print(numero + " ");

			}
			System.out.println();

		}
	}

}
