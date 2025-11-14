package ejercicios.EjercicioR24;

import java.util.Scanner;

public class EjercicioR24 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);

		Integer num1, total1=0;
		do {
			System.out.println("Dime un numero mayor que 0");
			num1 = skynnet.nextInt();
		} while (num1 == 0);
		for (Integer suma1 = 1; num1 >= suma1; suma1 += 2) {
			//System.out.println(suma1);
			total1 += suma1;
		}
		System.out.print("El numero total es: " + total1);
		skynnet.close();

	}

}
