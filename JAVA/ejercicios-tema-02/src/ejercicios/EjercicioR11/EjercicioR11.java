package ejercicios.EjercicioR11;

import java.util.Scanner;

public class EjercicioR11 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Integer numero1, numero2, select1;
		System.out.println("Dime un numero entero:");
		numero1 = skynnet.nextInt();
		System.out.println("Dime otro numero entero:");
		numero2 = skynnet.nextInt();
		do {
			
			System.out.println("***MENÚ****\n\t1.Sumar\n\t2.Restar\n\t3.Multiplicar\n\t4.Dividir\n\t0.Salir");
			 select1 = skynnet.nextInt();
			if (select1 == 1) {
				System.out.println("su suma: " + numero1 + numero2);
			} else if (select1 == 2) {
				System.out.println("su resta: " + (numero1 - numero2));
			} else if (select1 == 3) {
				System.out.println("Su multiplicación: " + numero1 * numero2);
			} else if (select1 == 4) {
				if (numero2==0) {
					System.out.println("division no posible");	
				}
				else {
					System.out.println("Su división: " + numero1 / numero2);
				}
			}
			else if (select1>4 || select1<0) {
				System.out.println("ERROR");
			}

		} while (select1!=0);
		System.out.println("BYE BYE");

	}
}
