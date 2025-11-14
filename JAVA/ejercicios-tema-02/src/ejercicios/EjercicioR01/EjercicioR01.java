package ejercicios.EjercicioR01;

import java.util.Scanner;

public class EjercicioR01 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Deme su nombre: ");
		String nombre = skynnet.nextLine();
		System.out.println("deme su año de nacimiento:");
		Integer año = skynnet.nextInt();
		Integer futuro= 2030-año;
		System.out.println("Su nombre es "+nombre+" y su edad en 2030 es "+futuro);
		skynnet.close();
		
	}

}
