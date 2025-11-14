package ejercicios.EjercicioR21;

import java.util.Scanner;

public class EjercicioR21 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Integer limite1;
		do {
			System.out.println("Dame un numero mayor que 0:");
			limite1 = skynnet.nextInt();
			for (Integer fila=0; fila<limite1;fila++) {
				for (Integer columnas=0;columnas<limite1;columnas++) {
					if (fila==columnas) {
						System.out.print("*");
					}
					else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			
		} while (limite1<=0);
			
			
		skynnet.close();
	
	}
}
