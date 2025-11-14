package ejercicios.EjercicioR12;

import java.util.Iterator;
import java.util.Scanner;

public class EjercicioR12 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Integer limite, version;
		do {
			System.out.println("***Menú***\n\t1.Version normal\n\t2.Version mejorada\n\t3.Versión definnitiva");
			version = skynnet.nextInt();
			System.out.println("Dame un numero mayor que 0:");
			limite = skynnet.nextInt();

			if (version == 1) {
				for (Integer fila = 1; fila <= limite; fila++) {
					for (Integer columna = 1; columna <= limite; columna++) {
						System.out.print("☐");
					}
				}
			} else if (version == 2) {
				for (Integer fila = 1; fila <= limite; fila++) {
					for (Integer columna = 1; columna <= limite; columna++) {
						if ((fila + columna) % 2 == 0) {
							System.out.print("⬜");
						} else {
							System.out.print("⬛");
						}
					}
				}

			}
			else if (version==3) {
				System.out.print(" ");
				for (Integer techo = 1; techo < limite; techo++) {
		
						System.out.print("___");
					}
					System.out.println("__ ");
				for (Integer fila = 1;fila<=limite;fila++) {
					for (Integer columna = 1; columna <= limite; columna++) {
					System.out.print("|__");
				}
					System.out.println("|");
				}
		
				
					
				}
			

			

		} while (limite != 0);
		System.out.println("ERROR");
		skynnet.close();

	}

}
