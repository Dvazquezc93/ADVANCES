package ejercicios.Ejercicios02;

import java.util.Scanner;

public class Ejercicios02 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Dime un número:");
		Integer numero1 = skynnet.nextInt();
		Integer arra1[] = new Integer[6];
		Integer suma1 = 0;
		for (Integer i = 0; i < arra1.length; i++) {
			
			arra1[i] = numero1*numero1;
			numero1++;
			
		}
		System.out.println("Sus números son: ");
		for (Integer i = 0; i < arra1.length; i++) {
			System.out.print(arra1[i]+"-");

		}
		skynnet.close();

	}

}
