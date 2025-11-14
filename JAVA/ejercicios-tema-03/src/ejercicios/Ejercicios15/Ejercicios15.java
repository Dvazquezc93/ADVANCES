package ejercicios.Ejercicios15;

import java.util.Scanner;

public class Ejercicios15 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		String num1 ="";
		do {
			System.out.println("Dime un numero de mas de una cifras");
			num1 = skynnet.nextLine();
		} while (num1.length()<2);
		String[] arra1= num1.split("");
		String numI="";
        for (int i = num1.length() - 1; i >= 0; i--) {
           numI+=arra1[i];
        }
        
        if (num1.equals(numI)) {
            System.out.println("El número " + num1 + " es capicúa");
        } else {
            System.out.println("El número " + num1 + " NO es capicúa");
        }
		skynnet.close();

	}

}
