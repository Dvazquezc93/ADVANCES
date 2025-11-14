package ejercicios.Ejercicio11;

import java.util.Scanner;

public class Ejercicio11 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		String email, parteFinal;
	
		
		do {
			System.out.println("digame el email: ");
			email = skynnet.nextLine();
			Integer posArroba = email.indexOf("@");
			parteFinal = email.substring(posArroba+1);
			
			
		} while (!email.contains("@") || email.contains("@.") || parteFinal.startsWith(".")|| !parteFinal.contains("."));
		System.out.println(email + " ha sido hackeado en 3 2 1");
		skynnet.close();
	}
}