package ejercicios.Ejercicios07;

import java.math.BigDecimal;
import java.util.Scanner;

import ejercicios.Ejercicios06.ParametroIncorrectoException;

public class AppSociedad {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sociedad s1 = new Sociedad();
		String parametro = "", parametro2 = "";
		BigDecimal altura = BigDecimal.ZERO;
		try {
			do {
				try {
					System.out.println("DATOS PERSONA \nDime el género:");
					parametro = sc.nextLine();
					System.out.println("Cual es su altura:");
					altura = sc.nextBigDecimal();
					try {
						s1.addPersona(parametro, altura);
					} catch (ParametroIncorrectoException e) {
						System.out.println(e.getMessage());
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				System.out.println("¿Quiere añadir otra persona?");
				sc.nextLine();
				parametro2 = sc.nextLine();
			} while (!parametro2.equalsIgnoreCase("no"));
		} finally {
			sc.close();
			System.out.println("La media de hombres son "+s1.alturaMediaHombre());
			System.out.println("La media de mujeres son "+s1.alturaMediaMujer());
			System.out.println("La media es "+s1.alturaMedia());
			
		}
		
	}

}
