package ejercicios.EjercicioR09;

import java.util.Scanner;

import ejercicios.EjercicioR08.EjercicioR08;

public class EjercicioR09 extends EjercicioR08 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		String texto;
		String texto2;
		do {
		System.out.println("Escribe un texto:");
		texto = skynnet.nextLine();
		if (texto.startsWith("Hola") && texto.endsWith("hastaluego")) {
			texto2 = texto.substring(5,texto.length()-10);
			System.out.println("He comprendido:" + texto2);
			}
		else if (!texto.startsWith("Hola") && !texto.endsWith("hastaluego")&& !texto.endsWith("adios")) {
			do {
				System.out.println("Repitamelo de nuevo, por favor.");
				texto = skynnet.nextLine();
				texto2 = texto.substring(5,texto.length()-10);
				System.out.println("He comprendido:" + texto2);
			} while (!texto.startsWith("Hola") && !texto.endsWith("hastaluego"));
		}
		}	
		while (!texto.startsWith("hola") && !texto.endsWith("adios"));
		texto2 = texto.substring(5,texto.length()-5);
		System.out.println("He comprendido:" + texto2);
		
		skynnet.close();
		}
}
