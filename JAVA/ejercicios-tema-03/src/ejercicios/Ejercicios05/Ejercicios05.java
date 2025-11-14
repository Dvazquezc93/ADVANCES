package ejercicios.Ejercicios05;

import java.util.Iterator;
import java.util.Scanner;

public class Ejercicios05 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Cuantos números me vas a decir:");
		Integer cont1 = skynnet.nextInt();
		Integer arra1[] = new Integer[cont1];
		Integer max1=0,min1=0,total1=0,  e=0;
		for (Integer i = 0; i < arra1.length; i++) {
			System.out.println("dime el numero:");
			arra1[i] = skynnet.nextInt();
		}
		for (Integer i = 0; i < arra1.length; i++) {
			System.out.print(arra1[i] + " ");
		}
		System.out.println();
		for (Integer i = 0; i < arra1.length; i++) {
			if (arra1[i] > max1) {
				max1 = arra1[i];
				e=i;
			}
		}
		min1=max1;
		System.out.println("Su numero maximo es " + max1+" y su posicion es "+ e);
		for (Integer i = 0; i < arra1.length; i++) {
			if (arra1[i] <min1) {
				min1 = arra1[i];
				e=i;
			}
		}
		System.out.println("Su numero minimo es " + min1+" y su posicion es "+ e);
		for (Integer i = 0; i < arra1.length; i++) {
			total1 = total1 + arra1[i];

		}
		System.out.println("Su media es: " + total1 / cont1);
		skynnet.close();

	}

}
