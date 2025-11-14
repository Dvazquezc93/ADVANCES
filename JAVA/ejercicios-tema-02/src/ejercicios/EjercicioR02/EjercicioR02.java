package ejercicios.EjercicioR02;

import java.util.Scanner;

public class EjercicioR02 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("dime una ciudad :");
		String ciudad1 = skynnet.nextLine();
		System.out.println("dime otra ciudad :");
		String ciudad2 = skynnet.nextLine();
		System.out.println("dime otra ciudad mas :");
		String ciudad3 = skynnet.nextLine();

		if (ciudad1.length() < ciudad2.length() && ciudad1.length() < ciudad3.length()) {
			System.out.println(ciudad1);
			if (ciudad2.length() < ciudad3.length()) {
				System.out.println(ciudad2);
				System.out.println(ciudad3);
			}

			else {
				System.out.println(ciudad3);
				System.out.println(ciudad2);

			}
		}
		if (ciudad2.length() < ciudad1.length() && ciudad2.length() < ciudad3.length()) {
			System.out.println(ciudad2);
			if (ciudad1.length() < ciudad3.length()) {
				System.out.println(ciudad1);
				System.out.println(ciudad3);
			} 
			else if (ciudad1.length() > ciudad3.length()) {
				System.out.println(ciudad3);
				System.out.println(ciudad1);
			}
		}

			if (ciudad3.length() < ciudad2.length() && ciudad3.length() < ciudad1.length()) {
				System.out.println(ciudad3);
				if (ciudad2.length() < ciudad1.length()) {
					System.out.println(ciudad2);
					System.out.println(ciudad1);
				} else {
					System.out.println(ciudad1);
					System.out.println(ciudad2);
				}

			}

		
		skynnet.close();
	}

}
