package ejercicios.Ejerciciosr04;

import java.util.Scanner;

public class Ejerciciosr04 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Dicta tu telegrama: ");
		String tel1 = skynnet.nextLine();
		String[] arra1 = tel1.split("STOP");
		String sin2 ="";
		for (String tel2 : arra1) {
			sin2+=tel2;
		}
		String[] arra2 = sin2.split(" ");
		Double precio1 = arra2.length * 0.24;
		System.out.println();
		System.out.println("El precio del telegrama es: " + precio1);
		skynnet.close();

	}

}
