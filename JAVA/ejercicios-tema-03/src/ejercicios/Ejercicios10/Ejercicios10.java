package ejercicios.Ejercicios10;


import java.util.Scanner;

public class Ejercicios10 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Integer  cont1=0;
		do {
			System.out.println("Dime un número mayor que 2:");
			cont1 = skynnet.nextInt();
		} while (cont1<2);
		Integer arra1[] = new Integer[cont1];
		for (Integer i = 0; i < 2; i++) {
			arra1[i]=i;
			System.out.print(arra1[i]+", ");
			
		}
		for (Integer i = 2; i < arra1.length; i++) {
			arra1[i]=arra1[i-1]+arra1[i-2];
			
		}
		for (Integer i = 2; i < arra1.length; i++) {
			System.out.print(arra1[i]+", ");
		}
		skynnet.close();
	}

}
