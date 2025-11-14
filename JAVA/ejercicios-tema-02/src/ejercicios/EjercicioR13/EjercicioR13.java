package ejercicios.EjercicioR13;

import java.util.Scanner;

public class EjercicioR13 {

	public static void main(String[] args) {
		Scanner skynnet= new Scanner (System.in);
		String  frase1="";
		String  total1="";
		while (!frase1.equalsIgnoreCase("fin")) {
			System.out.println("dime una frase:");
			frase1=skynnet.nextLine();
			if (!frase1.equalsIgnoreCase("fin")) {
				total1+=frase1+" ";
			}
			
			
		}
		System.out.println("Estas son tus frases: " + total1);
	skynnet.close();

	}

}
