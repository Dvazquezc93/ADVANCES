package ejercicios.EjercicioR20;

import java.util.Iterator;

public class EjercicioR20 {

	public static void main(String[] args) {
		Integer limite1=5;
		for (Integer fila=1; fila<=limite1;fila++) {
			for (Integer columnas=1;columnas<=limite1;columnas++) {
				if (fila==columnas) {
					System.out.print("*");
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println();
		}

	}

}
