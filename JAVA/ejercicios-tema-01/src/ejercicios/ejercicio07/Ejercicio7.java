package ejercicios.ejercicio07;

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("¿Cual es su altura?");
		Float altura = skynnet.nextFloat();
		System.out.println("¿Cual es su peso?");
		Integer peso = skynnet.nextInt();
		System.out.println("Su IMC es: " + (peso / (altura * altura )));
		skynnet.close();
	}	
}
