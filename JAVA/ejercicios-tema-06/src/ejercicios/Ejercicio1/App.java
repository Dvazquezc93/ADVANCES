package ejercicios.Ejercicio1;

import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		PersonaService s = new PersonaService();
		Boolean existe = true;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				try {
					existe = true;
					System.out.println("***BASE DE DATOS PERSONAS*** \nDime un dni:");
					System.out.println(s.consultarPersonal(sc.nextLine()));

				} catch (PersonaNotFoundException e) {
					existe = false;
					System.out.println(e.getMessage());
				} catch (PersonaException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

			} while (!(existe));
		}
		try {
			List<Persona>lista =s.BuscarPersonas("l");
			for (Persona persona : lista) {
				System.out.println(persona);
			}
		} catch (PersonaNotFoundException | PersonaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
