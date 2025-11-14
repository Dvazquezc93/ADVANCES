package ejercicios.Ejercicios16;

import java.util.Scanner;

public class Ejercicios16 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner (System.in);
		System.out.println("Dime un texto:");
		String text1 = skynnet.nextLine();
		String arra1[]=text1.split("");
		Integer cont1=0;
		for (Integer i=0;i<text1.length()-1;i++) {
			String deletreo = arra1[i];
			if (deletreo.equals("a")) {
				cont1++;
			}
			
			
		}
		System.out.println("tu texto contiene "+cont1+" a.");
		skynnet.close();

	}

	}


