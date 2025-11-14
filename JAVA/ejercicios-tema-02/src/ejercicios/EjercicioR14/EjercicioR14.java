package ejercicios.EjercicioR14;

import java.util.Scanner;

public class EjercicioR14 {

	public static void main(String[] args) {
		Scanner skynnet= new Scanner (System.in);
		String palabra1, limite1;
		do {
			System.out.println("Dime una contraseña:");
			palabra1= skynnet.nextLine();
			
			
			
		} while (palabra1.length()<8);
		palabra1= palabra1.replaceAll("a","4");
		palabra1= palabra1.replaceAll("e","3");
		palabra1= palabra1.replaceAll("i","1");
		palabra1= palabra1.replaceAll("o","0");
		palabra1= palabra1.replaceAll("t","7");
		System.out.println("su palabra final es: "+ palabra1);
		
		
		
		
		skynnet.close();

	}

}
