package ejercicios.EjercicioA04;

import java.util.Scanner;

public class EjercicioA04 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		String num1 ="";
		do {
			System.out.println("Dime un numero de mas de una cifras");
			num1 = skynnet.nextLine();
		} while (num1.length()<2);
		String num1Invertido = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            num1Invertido += num1.charAt(i);
        }
        
        if (num1.equals(num1Invertido)) {
            System.out.println("El número " + num1 + " es capicúa");
        } else {
            System.out.println("El número " + num1 + " NO es capicúa");
        }
		skynnet.close();
	}

}
