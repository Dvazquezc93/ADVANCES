package ejercicios.Ejercicio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
					System.out.print("***BASE DE DATOS PERSONAS*** \nDime un dni:");
					System.out.println(s.consultarPersonal(sc.nextLine()));

				} catch (PersonaNotFoundException e) {
					existe = false;
					System.out.println(e.getMessage());
				} catch (PersonaException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

			} while (!(existe));

			try {
				System.out.print("Dime que buscar en el nombre y apellidos:");
				List<Persona> lista = s.buscarPersonas(sc.nextLine());
				for (Persona persona : lista) {
					System.out.println(persona);
				}

			} catch (PersonaNotFoundException | PersonaException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("***Creador De Personas***");
			try {
				s.insertarPersona(validarPersona(sc));
			} catch (PersonaException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("***Actualizador De Personas***");
			try {
				s.actualizarPersonas(validarPersona(sc));
			} catch (PersonaException | PersonaNotFoundException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("***Borrador De Personas***");
			try {
				System.out.print("Dime el DNI:");
				s.borrarPersonas(sc.nextLine());
			} catch (PersonaException | PersonaNotFoundException e) {
				e.getMessage();
			}
		}
	}

	private static Persona validarPersona(Scanner sc) {
		Persona p = new Persona();
		Boolean ac = true;
		do {
			try {

				System.out.print("Dime el Nombre:");
				p.setNombre(sc.nextLine());
				System.out.print("Dime el Apellido:");
				p.setApellidos(sc.nextLine());
				System.out.print("Dime el DNI:");
				p.setDni(sc.nextLine());
				System.out.print("Dime la fecha de nacimiento:");
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				p.setFechaNacimiento(LocalDate.parse(sc.nextLine(), formato));
				p.validar();
			} catch (DatosIncompletosException e) {
				System.out.println(e.getMessage());
				ac = false;
			} catch (DateTimeParseException e) {
				System.out.println("No ha introducido correctamente la fecha");
				ac = false;
			}
		} while (!ac);
		return p;
	}
}
