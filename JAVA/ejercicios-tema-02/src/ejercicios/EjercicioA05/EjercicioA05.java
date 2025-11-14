package ejercicios.EjercicioA05;

import java.util.Iterator;
import java.util.Scanner;

public class EjercicioA05 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner (System.in);
		System.out.println("Dime un texto:");
		String text1 = skynnet.nextLine();
		Integer cont1=0;
		for (Integer i=0;i<text1.length()-1;i++) {
			String deletreo = text1.substring(i, i+1);
			if (deletreo.equals("a")) {
				cont1++;
			}
			
			
		}
		System.out.println("tu texto contiene "+cont1+" a.");
		skynnet.close();

	}

}
