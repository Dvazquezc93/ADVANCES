package TipoA1DanielVázquezChinchilla;

import java.util.Scanner;

public class TipoA1DanielVázquezChinchilla {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Integer num1;
		do {

			System.out.println("Dime una numero ");
			num1 = skynnet.nextInt();
			if (num1 < 1000 || num1 > 2000) {
				System.out.println("tiene que ser entre 10000 y 20000");
			}
		} while (num1 < 10000 || num1 > 20000);
		String num2 = num1.toString();
		String[] arra1 = num2.split("");
		String cont1 = arra1[0];
		for (String deletreo : arra1) {
			if (cont1.contains(deletreo)) {
				cont1 += deletreo;
			}
		}
		System.out.println("Su numero tiene " + cont1.length() + " digitos");
		skynnet.close();

	}

}
