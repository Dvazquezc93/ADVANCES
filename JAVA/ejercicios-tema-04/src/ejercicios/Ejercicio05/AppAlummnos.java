package ejercicios.Ejercicio05;

import ejercicios.Ejercicio02.ConsoleInOut;
import ejercicios.Ejercicio04.Alumno;

public class AppAlummnos {

	public static void main(String[] args) {
		ConsoleInOut console = new ConsoleInOut();
		String dni="";
		Alumno misAlumnos = new Alumno(dni);
		console.write("****Alumno****");
		misAlumnos.setNombre(console.readString("¿Cual es su nombre?"));
		misAlumnos.setEdad(console.readInteger("¿Cual es su edad?"));
		misAlumnos.setDni(console.readString("¿Cual es su dni?"));
		String nota =console.readString("¿Ha aprobado?");
		if (nota.equalsIgnoreCase("si")) {
			misAlumnos.aprobar();
		}
		else {
			misAlumnos.setNota(console.readDouble("¿Cual es su nota?"));
		}
		console.write("****REGISTRADO CORRECTAMENTE****");
		console.write("El nombre del alumno es: " + misAlumnos.getNombre() + "\nLa edad del alumno es :"
				+ misAlumnos.getEdad() + "\nEl DNI del alumno es: " + misAlumnos.getDni()
				+ "\nLa nota del alumno es: " + misAlumnos.getNota());
		console.close();
	}

}
