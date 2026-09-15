package ejercicios.Ejercicio45;

import java.util.Iterator;
import java.util.Scanner;

public class AppGeografia {

	public static void main(String[] args) {
		Geografia g1 = new Geografia();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("Dime el país "+(i+1)+":");
			String pais = sc.nextLine();
			System.out.print("Dime su capital:");
			Boolean paisEsta= g1.agregarPais(pais, sc.nextLine());
			if (paisEsta) {
				System.out.println("Ese país ya esta introducido, actualizamos capital.");
				i--;
			}
		}
		g1.imprimirPaises();
		System.out.println("Su número promedio de palabras es: "+g1.calcularLongitudMediaPaises());
		g1.imprimirNumeroPaisesLetra("b");
		System.out.println(g1.mismaLetra());
		g1.eliminarPaisConCapitalLetra("b");
		g1.imprimirPaises();
	}

}
