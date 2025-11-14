package ejercicios.Ejercicios12;

import java.util.Iterator;
import java.util.Scanner;

public class Ejercicios12 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Dime una direccion web:");
		String web = skynnet.nextLine();
		String[] arra1 = web.split("//");
		System.out.println(arra1[0] + "//");
		
		arra1= arra1[1].split("\\.");
		for (Integer i = 0; i < arra1.length; i++) {
			System.out.println(arra1[i]);

		}
		skynnet.close();

	}

}
