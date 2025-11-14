package ejercicios.ejercicio04;

import java.util.Scanner;


public class Ejercicio4 {
	public static final Integer Año_Actual = 2025;
			
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("¿Su año de nacimiento?");
		Integer nacimiento= skynnet.nextInt();
		System.out.println("su edad es: "+ (Año_Actual - nacimiento) + " años ");
		skynnet.close();
	}

}
