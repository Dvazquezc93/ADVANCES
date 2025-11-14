package ejercicios.ejercicio03;

import java.util.Scanner;

public class Ejercicios03 {

	public static void main(String[] args) {
	Scanner skynnet = new Scanner(System.in);
	System.out.println("¿Cual es su edad?");
	String edad=skynnet.nextLine();
	System.out.println("Su edad es: "+ edad + " años");
	skynnet.close();

	}

}
