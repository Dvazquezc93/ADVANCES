package ejercicios.Ejercicios14;

import java.util.Iterator;
import java.util.Scanner;

public class Ejercicios14 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("dime un texto: ");
		String texto1 = skynnet.nextLine();
		texto1 = texto1.toLowerCase().toLowerCase();
		String[] arra1 = texto1.split("");
		String totalM = arra1[0];

		for (Integer i = 1; i < arra1.length; i++) {
			if (arra1[i].equals(" ")) {
				i++;
				totalM += arra1[i].toUpperCase();
			} else {
				totalM += arra1[i];
			}
		}
		System.out.println(totalM);
		skynnet.close();
	}
}
