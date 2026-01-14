package ejercicios.Ejercicio11;

import java.util.Iterator;

import ejercicios.Ejercicio02.ConsoleInOut;
import ejercicios.Ejercicio04.Alumno;
import ejercicios.Ejercicio08.Curso;

public class AppAlumnos {

	public static void main(String[] args) {

		ConsoleInOut console = new ConsoleInOut();
		Alumno[] arraAlumnos = new Alumno[console.readInteger("¿Cuantos alumnos vas a introducir?")];
		
		Curso miCurso = new Curso(1L, "DAM-DAW");
		for (Integer i = 0; i < arraAlumnos.length; i++) {
			console.write("****Alumno " + (i + 1) + "****");
			arraAlumnos[i] = new Alumno(null);
			arraAlumnos[i].setNombre(console.readString("¿Cual es su nombre?"));
			arraAlumnos[i].setEdad(console.readInteger("¿Cual es su edad?"));
			do {
				arraAlumnos[i].setDni(console.readString("¿Cual es su dni?"));
			} while (arraAlumnos[i].validarDni() == false);
			String nota = console.readString("¿Ha aprobado?");
			if (nota.equalsIgnoreCase("si")) {
				arraAlumnos[i].aprobar();
			} else {
				arraAlumnos[i].setNota(console.readDouble("¿Cual es su nota?"));
			}
			arraAlumnos[i].setCurso(miCurso);
		}
		Boolean alumnosIguales = false;
		for (Integer i = 0; i < arraAlumnos.length; i++) {
			for (Integer j = i + 1; j < arraAlumnos.length; j++) {
				if (arraAlumnos[i].equals(arraAlumnos[j])) {
					alumnosIguales = true;
				}
			}
		}
		if (alumnosIguales == false) {
			console.write("****REGISTRADO CORRECTAMENTE****");
		} else if (alumnosIguales = true) {
			console.write("XXXX ALUMNOS DUPLICADOS XXXX");
		}
		console.write("****VALIDACION ALUMNOS****");
		for (Integer i = 0; i < arraAlumnos.length; i++) {
			if (arraAlumnos[i].Validar() == false) {
				console.write("El alumno " + arraAlumnos[i].getNombre() + " tiene datos invalidos.");
			}

		}

		console.close();
	}

}
