package ejercicios.Ejercicio1;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		PersonaService s = new PersonaService();
		String condicion = "";
		try (Scanner sc = new Scanner(System.in)) {
			do {
				try {
					System.out.println("***BASE DE DATOS PERSONAS*** \nDime un dni:");
					System.out.println(s.consultarPersonal(sc.nextLine()));

				} catch (PersonaNotFoundException e) {
					System.out.println("Con ese dni no hay personas en la base de datos");
				} catch (PersonaException e) {
					e.printStackTrace();
				}
				System.out.println("¿Quieres comprobar otro dni?");
				condicion = sc.nextLine();
			} while (!(condicion.equalsIgnoreCase("no")));
		}
	}

}
