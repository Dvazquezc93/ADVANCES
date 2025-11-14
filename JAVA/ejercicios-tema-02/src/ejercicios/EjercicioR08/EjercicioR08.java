package ejercicios.EjercicioR08;


import java.util.Scanner;

public class EjercicioR08 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Escribe un texto:");
		String texto = skynnet.nextLine();
		String texto2;

		if (texto.startsWith("Hola") && texto.endsWith("Hastaluego")) {
			
			texto2 = texto.substring(5,texto.length()-10);
			System.out.println("He comprendido:" + texto2);
		} else {
			do {
				System.out.println("Repitamelo de nuevo, por favor.");
				texto = skynnet.nextLine();
				texto2 = texto.substring(5,texto.length()-10);
				System.out.println("He comprendido:" + texto2);
			} while (!texto.startsWith("Hola") && !texto.endsWith("hastaluego"));
		}
		skynnet.close();
	}

}
