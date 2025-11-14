package ejercicios.Ejercicio18;

import java.util.Iterator;

public class Ejercicio18 {

	public static void main(String[] args) {
		Integer limite = 5;

		for (Integer fila = 1; fila <= limite; fila++) {
			for (Integer columna = 1; columna <= limite; columna++) {
				System.out.print(columna + " ");

			}
			System.out.println();
		}

	}

}
