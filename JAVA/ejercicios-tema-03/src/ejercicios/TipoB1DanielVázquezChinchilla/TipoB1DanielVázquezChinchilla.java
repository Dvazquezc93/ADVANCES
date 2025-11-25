package TipoB1DanielVázquezChinchilla;

import java.util.Iterator;
import java.util.Scanner;

public class TipoB1DanielVázquezChinchilla {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Integer num1 = 0, back1 = 1;
		do {
			System.out.println("Dime un numero del 1 al 9:");
			num1 = skynnet.nextInt();
		} while (num1 < 0 || num1 > 9);

		for (Integer fila = num1; fila > 0; fila--) {
			for (Integer e = 1; e < fila; e++) {
				System.out.print(" ");
			}
			for (Integer columnas = fila; columnas <= num1; columnas++) {
				System.out.print(columnas);
			}
			for (Integer c= num1-1;c>=fila;c--) {
				System.out.print(c);
				
			}
			System.out.println();
		}
		skynnet.close();
	}

}
