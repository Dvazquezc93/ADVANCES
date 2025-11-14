package ejercicios.Ejercicios08;

import java.util.Scanner;

public class Ejercicios08 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Cuantos números me vas a decir:");
		Integer cont1 = skynnet.nextInt();
		Integer arra1[] = new Integer[cont1];
	

		for (Integer i = 0; i < arra1.length; i++) {
			System.out.println("dime el numero:");
			arra1[i] = skynnet.nextInt();
			
		}
		for (Integer i = 0; i < arra1.length; i++) {
			System.out.println("su número son " + arra1[i]);
			
		}
		
		for (Integer i = 0, fin = arra1.length-1; i < fin; i++,fin--) {
			Integer aux = arra1[i];
			arra1[i]=arra1[fin];
			arra1[fin]= aux;
		}
		for (Integer i = 0; i < arra1.length; i++) {
			System.out.println("Sus numeros inversos son: "+arra1[i]);
			
		}
		skynnet.close();

	}

}
