package ejercicios.EjercicioR18;

import java.util.Scanner;

public class EjercicioR18 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Dime una palabra:");
		String palabra = skynnet.nextLine();
		
		for (Integer letra = palabra.length()-1; letra> -1;letra--) {
			char deletreo= palabra.charAt(letra);
			System.out.print(deletreo);
		}
		skynnet.close();

	}

}
