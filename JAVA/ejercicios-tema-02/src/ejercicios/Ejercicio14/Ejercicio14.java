package ejercicios.Ejercicio14;

import java.util.Scanner;

public class Ejercicio14 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Integer n = 0;
		Integer n2 = 0;
		Integer n3 = 0;
 
		System.out.println("Dime un numero: ");
		n = skynnet.nextInt();
 
		do {
			n2 = n * n3;
			System.out.println(n + "x" + n3 + "=" + n2);
			n3++;
		} while (n3!=11);
 
		skynnet.close();
	}

}
