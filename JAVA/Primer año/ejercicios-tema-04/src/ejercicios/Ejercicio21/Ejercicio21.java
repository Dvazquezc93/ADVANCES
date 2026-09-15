package ejercicios.Ejercicio21;

import java.util.ArrayList;
import java.util.List;

import ejercicios.Ejercicio02.ConsoleInOut;
import ejercicios.Ejercicio04.Alumno;
import ejercicios.Ejercicio08.Curso;

public class Ejercicio21 {

	public static void main(String[] args) {
		ConsoleInOut console = new ConsoleInOut();
		Alumno misAlumnos = new Alumno(null);

		List<Alumno> arraAlumnos = new ArrayList<>();
		
		Curso miCurso = new Curso(null);
		for (Integer i = 0; i < 3; i++) {
			console.write("****Alumno " + (i + 1) + "****");
			arraAlumnos.add(misAlumnos);
			misAlumnos.setNombre(console.readString("¿Cual es su nombre?"));
			misAlumnos.setEdad(console.readInteger("¿Cual es su edad?"));
			do {
				misAlumnos.setDni(console.readString("¿Cual es su dni?"));
			} while (misAlumnos.validarDni() == false);
			String nota = console.readString("¿Ha aprobado?");
			if (nota.equalsIgnoreCase("si")) {
				misAlumnos.aprobar();
			} else {
				misAlumnos.setNota(console.readDouble("¿Cual es su nota?"));
			}
			miCurso.setDescripcion("DAM-DAW");
			miCurso.setIdentificador(1L);
			misAlumnos.setCurso(miCurso);
		}
		Boolean alumnosIguales = false;
		for (Integer i = 0; i < arraAlumnos.size(); i++) {
			for (Integer j = i + 1; j < arraAlumnos.size(); j++) {
				if (arraAlumnos.get(i).equals(arraAlumnos.get(j))) {
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
		for (Integer i = 0; i < arraAlumnos.size(); i++) {
			if (arraAlumnos.get(i).Validar() == false) {
				console.write("El alumno " + arraAlumnos.get(i).getNombre() + " tiene datos invalidos.");
			}

		}

		console.close();
	}

}