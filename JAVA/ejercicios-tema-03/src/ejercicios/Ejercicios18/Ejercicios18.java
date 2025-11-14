package ejercicios.Ejercicios18;

import java.util.Iterator;
import java.util.Scanner;

public class Ejercicios18 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Dime una palabra");
		String text1 = skynnet.nextLine();
		String[]arra1 = text1.split("");
		for (String text2 : arra1) {
			System.out.println(text2);
		}
		skynnet.close();

	}

}
