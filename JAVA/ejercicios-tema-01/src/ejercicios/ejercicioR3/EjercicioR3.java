package ejercicios.ejercicioR3;

import java.util.Scanner;

public class EjercicioR3 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("dime un numero entero: ");
		String n1= skynnet.nextLine();
		System.out.println("Dame otro numero entero: ");
		String n2= skynnet.nextLine();
		Long n11= Long.parseLong(n1);
		Long n22= Long.parseLong(n2);
		Long r0 = n11*n22;

		

		System.out.println("Su numero es " + r0);
		skynnet.close();
	

	}

}
