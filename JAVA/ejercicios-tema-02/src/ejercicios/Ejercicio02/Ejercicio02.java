package ejercicios.Ejercicio02;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		Scanner skynnet = new Scanner(System.in);
		System.out.println("¿Cual es su altura?");
		Float altura = skynnet.nextFloat();
		System.out.println("¿Cual es su peso?");
		Double peso = skynnet.nextDouble();
		Double imc = peso/(altura * altura);
		
		
		if (imc <= 18.5) {
			System.out.println("Peso inferior a lo normal.");
			}
		else if (imc<=24.9) {
			System.out.println("normal.");
			}
		else if (imc<=29.9) {
			System.out.println("peso superior de lo normal");
			}
		else if (imc<=30) {
			System.out.println("Obesidad.");
			}
		skynnet.close();
		


	}
}
