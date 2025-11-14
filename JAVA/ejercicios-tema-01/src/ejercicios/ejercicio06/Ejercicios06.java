package ejercicios.ejercicio06;

import java.util.Scanner;

public class Ejercicios06 {	
		public static final Double iva = 1.21;
		public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Digame el precio del producto:");
	    Double precio = skynnet.nextDouble();
	    System.out.println("el precio sin iva es "+(precio/iva)+" euros.");
	    skynnet.close();
	
}

}
