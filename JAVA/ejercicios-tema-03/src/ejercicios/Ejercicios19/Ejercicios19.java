package ejercicios.Ejercicios19;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Ejercicios19 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		String[] arra1 = new String[] { "azulejo", "tenedor", "saltamontes", "carretilla", "molinero", "sofisticado",
				"terremoto", "culinario", "teclado", "primavera" };
		Random ale1 = new Random();
		Integer ale2 = ale1.nextInt(10);
		String select1 = arra1[ale2];
		String op1;
		Integer vic1 = 0, der1 = 0,fin1=0;

		String[] arraS = select1.split("");
		String[] arraV = select1.split("");;
		arraV[0] = arraS[0];
		for (Integer i = 1; i < arraS.length; i++) {
			arraV[i] = "-";
		}
		System.out.println("***EL AHORCADO***\n ADIVINA LA PALABRA\n   ");

		for (Integer e = 0; der1 <= 11; e++) {
			for (String secret1 : arraV) {
				System.out.print(secret1);
			}
			System.out.println("\nDi una letra:");
			op1 = skynnet.nextLine();
			Integer cont2 = 1;
			for (Integer i = 1; i < arraS.length; i++) {
				if (op1.equalsIgnoreCase(arraS[i])) {
					arraV[i] = arraS[i];
					vic1++;
				} else if (!(op1.equalsIgnoreCase(arraS[i]))) {
					cont2++;
				}
			}
			if (cont2 == arraS.length) {
				der1++;
				System.out.println("Lleva " + der1 + " palabras falladas.");
			}
			if (der1 == 10) {
				System.out.println("***Game Over****\n Has perdido " + der1 + " veces\n Has acertado " + vic1 + " veces");
				break;
			}
			
			if (vic1+1==arraV.length) {
				System.out.println("***YOU WIN***\nHas acertado la palabra");

			}
		}
		fin1=fin1+ale2;
		if (fin1==45) {
			System.out.println("***YOU WIN***\nHas acertado la palabra");
			
		}
		skynnet.close();
	}
}