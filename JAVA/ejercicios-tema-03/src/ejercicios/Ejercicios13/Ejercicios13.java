package ejercicios.Ejercicios13;

import java.util.Scanner;

public class Ejercicios13 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Dime una palabra:");
		String palabra = skynnet.nextLine();
		String[] arra1 = palabra.split("");
		for (Integer i = 0; i < arra1.length; i++) {
			System.out.println(arra1[i]);
		}
		skynnet.close();
	}

}
