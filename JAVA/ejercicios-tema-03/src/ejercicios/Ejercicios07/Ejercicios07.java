package ejercicios.Ejercicios07;


import java.util.Iterator;
import java.util.Scanner;

public class Ejercicios07 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Cuantos números me vas a decir:");
		Integer cont1 = skynnet.nextInt();
		Integer arra1[] = new Integer[cont1], arra2[] = new Integer[cont1];
		Integer b=1;

		for (Integer i = 0; i < arra1.length; i++) {
			System.out.println("dime el numero:");
			arra1[i] = skynnet.nextInt();
			b=i;
		}
		for (Integer i = 0; i < arra1.length; i++) {
			System.out.println("su número son " + arra1[i]);
			
		}
		
		for (Integer i = 0; i < arra1.length; i++) {
			arra2[i]=arra1[b];
			b--;
		}
		for (Integer i = 0; i < arra1.length; i++) {
			System.out.println("Sus numeros inversos son: "+arra2[i]);
			
		}
		skynnet.close();

	}

}
