package ejercicios.Ejercicio04;

import ejercicios.Ejercicio02.ConsoleInOut;

public class APP_ALUMNO {

	public static void main(String[] args) {
		ConsoleInOut console = new ConsoleInOut();
		Alumno misAlumnos = new Alumno(null);
		console.write("****Alumno****");
		misAlumnos.setNombre(console.readString("¿Cual es su nombre?"));
		misAlumnos.setEdad(console.readInteger("¿Cual es su edad?"));
		misAlumnos.setDni(console.readString("¿Cual es su dni?"));
		misAlumnos.setNota(console.readDouble("¿Cual es su nota?"));
		console.write("****REGISTRADO CORRECTAMENTE****");
		System.out.println("El nombre del alumno es: " + misAlumnos.getNombre() + "\nLa edad del alumno es :"
				+ misAlumnos.getEdad() + "\nEl DNI del alumno es: " + misAlumnos.getDni()
				+ "\nLa nota del alumno es: " + misAlumnos.getNota());
		console.close();

	}

}
