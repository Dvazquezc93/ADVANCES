package ejercicios.EjercicioA03;

import java.util.Iterator;

public class EjercicioA03 {

	public static void main(String[] args) {

		for (Integer fila1 = 1; fila1 <= 9; fila1++) {
			System.out.print(fila1);
		}
		System.out.println();
		for (Integer fila2 = 1; fila2 <= 9; fila2++) {
			if (fila2 % 2 == 0) {
				System.out.print(fila2);
			}
		}
		System.out.println();
		for (Integer fila3 = 1; fila3 <= 9; fila3++) {
			if (fila3 % 3 == 0) {
				System.out.print(fila3);
			}
		}
		System.out.println();
		for (Integer fila4 = 1; fila4 <= 9; fila4++) {
			if (fila4 % 4 == 0) {
				System.out.print(fila4);
			}

		}
		System.out.println();
		for (Integer fila5 = 1; fila5 <= 9; fila5++) {
			if (fila5 % 5 == 0) {
				System.out.print(fila5);
			}
		}
	}
}
