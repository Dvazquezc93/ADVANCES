package ejercicios.ejercicioR4;

import java.util.Scanner;

public class EjercicioR4 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Dime tu numero favorito:");
		Long n = skynnet.nextLong();
		skynnet.nextLine();
		System.out.println("Dime tu ciudad favorita: ");
		String c = skynnet.nextLine();
		System.out.println("Tu numero es "+n+" y tu ciudad es "+c);
		skynnet.close();
		
	}

}
