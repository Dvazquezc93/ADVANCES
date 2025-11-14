package ejercicios.Ejercicio10;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		String palabra1,palabra2;
		
		do {
			System.out.println("dime una palabra:");
			palabra1= skynnet.nextLine();
			System.out.println("dime otra palabra:");
			palabra2= skynnet.nextLine();
			 
		} while (palabra1.isBlank()||palabra2.isBlank());
		if (palabra1.compareTo(palabra2)<0) {
			System.out.println(palabra2 +","+ palabra1);
		}
		else {
			System.out.println("Las dos son igual:"+ palabra1 + palabra2);
			
		}
		skynnet.close();
	}

}
