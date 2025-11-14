package ejercicios.EjercicioR16;

import java.util.Iterator;
import java.util.Scanner;

public class EjercicioR16 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner (System.in);
		System.out.println("dime una palabra:");
		String palabra = skynnet.nextLine();
	
		for (Integer i=0; i<palabra.length();i++) {
			
			char deletreo = palabra.charAt(i);
			System.out.println(deletreo);
		}
		
		
		
		
		skynnet.close();
	}

}
