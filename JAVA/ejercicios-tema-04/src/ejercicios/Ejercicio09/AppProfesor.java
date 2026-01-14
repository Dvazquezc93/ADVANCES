package ejercicios.Ejercicio09;

import ejercicios.Ejercicio02.ConsoleInOut;
import ejercicios.Ejercicio04.Alumno;
import ejercicios.Ejercicio08.Curso;

public class AppProfesor {

	public static void main(String[] args) {
		ConsoleInOut console = new ConsoleInOut();
		String dni= "";
		Profesor misProfesores = new Profesor(dni);
		Curso miCurso = new Curso();
		console.write("****Profesor****");
		misProfesores.setNombre(console.readString("¿Cual es su nombre?"));
		misProfesores.setEdad(console.readInteger("¿Cual es su edad?"));
		misProfesores.setDni(console.readString("¿Cual es su dni?"));
		misProfesores.setNumeroAlumnos(console.readInteger("¿Cuantos número de alumnos tienes?"));
		miCurso.setDescripcion(console.readString("¿Cual es su curso?"));
		miCurso.setIdentificador(console.readInteger("¿El codigo de su curso?"));
		misProfesores.setCurso(miCurso);
		console.write("****REGISTRADO CORRECTAMENTE****");
		console.write(misProfesores.toString());
		console.close();

	}

}
