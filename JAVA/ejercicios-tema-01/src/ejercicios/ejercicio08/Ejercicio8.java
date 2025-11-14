package ejercicios.ejercicio08;

import java.util.Scanner;

public class Ejercicio8 {
public static void main(String[] args) {
	Scanner skynnet = new Scanner(System.in);
	System.out.println("Dime un numero:");
	String a= skynnet.nextLine();
	System.out.println("Dime un numero decimal:");
	Double b = skynnet.nextDouble();
	System.out.println("Dame un numero entero; ");
	Float c = skynnet.nextFloat();
	
	Long x1= Long.parseLong(a);
	String x2 = b.toString();
	Integer x3 = b.intValue();
	Long x4 = c.longValue();
	System.out.println("x1" + x1);
	System.out.println("x2" + x2);
	System.out.println("x3" + x3);
	System.out.println("x4" + x4);
	skynnet.close();
	}	
}
