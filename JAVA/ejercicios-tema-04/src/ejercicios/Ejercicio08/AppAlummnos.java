package ejercicios.Ejercicio08;

import java.util.Iterator;

import ejercicios.Ejercicio02.ConsoleInOut;
import ejercicios.Ejercicio04.Alumno;

public class AppAlummnos {
	public static void main(String[] args) {
		ConsoleInOut console = new ConsoleInOut();
		String dni = "";
		Alumno misAlumnos = new Alumno(dni);
		Curso miCurso = new Curso();
		console.write("****Alumno****");
		misAlumnos.setNombre(console.readString("¿Cual es su nombre?"));
		misAlumnos.setEdad(console.readInteger("¿Cual es su edad?"));
		misAlumnos.setDni(console.readString("¿Cual es su dni?"));
		String nota = console.readString("¿Ha aprobado?");
		if (nota.equalsIgnoreCase("si")) {
			misAlumnos.aprobar();
		} else {
			misAlumnos.setNota(console.readDouble("¿Cual es su nota?"));
		}
		miCurso.setDescripcion(console.readString("¿Cual es su curso?"));
		miCurso.setIdentificador(console.readInteger("¿El codigo de su curso?"));
		misAlumnos.setCurso(miCurso);
		console.write("****REGISTRADO CORRECTAMENTE****");
		console.write(misAlumnos.toString());
		console.close();
	}
}
