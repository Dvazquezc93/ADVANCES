package ejercicios.Ejercicios11;

import java.util.Scanner;

public class Ejercicios11 {
public static void main(String[] args) {
	Scanner skynnet= new Scanner(System.in);
	System.out.println("Nombre completo: ");
	String na = skynnet.nextLine();
	String[]arra1 = na.split(" ");
	for (Integer i = 0; i < arra1.length; i++) {
			if (i==0) {
				System.out.println("Su nombre es "+arra1[i]);
			}
			else if (i==1) {
				System.out.println("Su primer apellido es "+arra1[i]);
			}
			else if (i==2) {
				System.out.println("Su segundo apellido es "+arra1[i]);
			}
			}
	skynnet.close();
	
}
}
