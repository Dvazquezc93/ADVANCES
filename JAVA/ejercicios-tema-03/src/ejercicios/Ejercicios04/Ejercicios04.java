package ejercicios.Ejercicios04;

import java.util.Scanner;

public class Ejercicios04 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Cuantos números me vas a decir:");
		Integer cont1 = skynnet.nextInt();
		Integer arra1[] = new Integer[cont1];
		
		for (Integer i=0;i<arra1.length;i++) {
			System.out.println("dime el numero:");
			arra1[i]= skynnet.nextInt();
		}
		for (Integer i=arra1.length-1;i>=0;i--) {
			System.out.print(arra1[i]+" ");
			
		}
		
		skynnet.close();

	}

}
