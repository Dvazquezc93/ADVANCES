package ejercicios.ejercicio05;

import java.util.Scanner;

public class Ejercicio5 {
	public static final Integer meses=12;
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("¿cuanto le gustaria ganar al año?");
		Integer ganar = skynnet.nextInt();
		System.out.println( "Tu sueldo mensual sería de "+(ganar/meses)+ " euros.");
		skynnet.close();
		  
	}

}
