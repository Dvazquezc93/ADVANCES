package ejercicios.EjercicioA01;

import java.util.Iterator;
import java.util.Scanner;

public class EjercicioA01 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("dime un texto: ");
		String texto1 = skynnet.nextLine();
		texto1 = texto1.toLowerCase();
		String r1 = "";
		boolean mayus = false;
		for (Integer n1 = 0; n1 < texto1.length(); n1++) {
			String deletreo = texto1.substring(n1, n1 + 1);
			if (deletreo.equals(" ")) {
				mayus = true;
			} else {
				if (mayus) {
					r1 = r1 + deletreo.toUpperCase();
					mayus = false;
				} else {
					r1 = r1 + deletreo;
				}
			}
		}
		System.out.println(r1);
		skynnet.close();
	}

}
