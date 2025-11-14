package ejercicios.Ejercicio12;

import java.util.Scanner;

public class Ejercicio12 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		String usuario;
		do {
			System.out.println("dime un nombre de usuario:");
			usuario = skynnet.next();
			usuario = usuario.trim();
			usuario = usuario.toUpperCase();
			if (usuario.contains(" ") || usuario.length() < 10) {
				System.out.println("error");
			}
		} while (usuario.contains(" ") || usuario.length() < 10);

		System.out.println(usuario);
		skynnet.close();
	}
}
