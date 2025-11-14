package ejercicios.Ejercicio13;

import java.util.Scanner;

public class Ejercicio13 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("ponga un texto:");
		String texto = skynnet.nextLine();
		Integer inicio = 0;
		Integer fin = 5;
		String recorte;
		do {
			recorte = texto.substring(inicio, fin);
			System.err.println(recorte);
			inicio += 5;
			fin += 5;
		} while (fin <= texto.length());
		skynnet.close();

	}

}
