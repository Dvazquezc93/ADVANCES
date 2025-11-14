package ejercicios.EjercicioA02;

import java.util.Scanner;

public class EjercicioA02 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Integer limite1;
		do {
			System.out.println("Dame un numero mayor que 0:");
			limite1 = skynnet.nextInt();
			for (Integer fila=1; fila<=limite1;fila++) {
				for (Integer columnas=1;columnas<=limite1;columnas++) {
					if (fila==columnas|| fila+columnas==limite1+1) {
						System.out.print("*");
					}
					else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			
		} while (limite1<=0);
			

	}

}
