package ejercicios.EjercicioR15;

import java.util.Random;
import java.util.Scanner;

public class EjercicioR15 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Random num1 = new Random();
		Integer pos1=1, drift1=0;
		for (Integer try1=0; pos1!=try1 ; drift1++) {
			System.out.println("dime un numero del 0 al 9:");
			try1 = skynnet.nextInt();
			pos1 = num1.nextInt(0, 10);
			if (try1>9||try1<0) {
				System.out.println("Número erroneo.");
			}
			else if (pos1!=try1) {
				
				System.out.println("Ese no es el numero magico.");
			}
			
		}
		System.out.println("numero correcto, su puntuacion es " + (10-drift1 )+".");
 
		skynnet.close();
	}
}
