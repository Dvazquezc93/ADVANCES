package ejercicios.ejercicioR2;

import java.util.Scanner;

public class EjercicioR2 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("dime un numero entero: ");
		Long n1= skynnet.nextLong();
		System.out.println("Dame otro numero entero: ");
		Long n2= skynnet.nextLong();
		Long r0 = n1*n2;
		System.out.println("Su numero es " + r0);
		skynnet.close();
		
	
}

}
