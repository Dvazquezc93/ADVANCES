package ejercicios.Ejercicio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			PersonaService ps = new PersonaService();
			List<Persona> lista = new ArrayList();
			Integer contador = 0;

			do {
				try {
					Persona p = new Persona();
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
					contador++;
					lista.add(p);
				} catch (DatosIncompletosException e) {
					System.out.println(e.getMessage());
					break;
				} catch (DateTimeParseException e) {
					System.out.println("No ha introducido correctamente la fecha");
					break;
				}
			} while (contador < 3);
			try {
				ps.insertarPersonas(lista);
			} catch (PersonaException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
