package ejercicios.Ejercicios06;

import java.util.Scanner;

public class AppPersonas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Persona p1 = new Persona();

		do {
			try {
				System.out.println("DATOS DE LA PERSONA \nCual es su género:");
				p1.setGenero(sc.nextLine());
				System.out.println("Cual es su altura:");
				p1.setAltura(sc.nextBigDecimal());
			} catch (ParametroIncorrectoException e) {
				System.out.println(e.getMessage());
			}

		} while (p1.getAltura() == null || p1.getGenero() == null);
		sc.close();
	}

}
