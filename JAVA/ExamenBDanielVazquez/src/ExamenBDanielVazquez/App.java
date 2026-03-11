package ExamenBDanielVazquez;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

		private static String pedirEmail() {
			Scanner sc =new Scanner(System.in);
			String email="";
			do {
				System.out.println("Dime el email del primer alumno:");
				email= sc.nextLine();
				if (!(email.contains("@"))|| email.length()<10) {
					System.out.println("El email es incorrecto");
				}
			} while (!(email.contains("@"))&& email.length()>10);
			return email;
		}

		// No debes modificar nada del m�todo main, salvo que hayas llamado a tus clases o m�todos con otro nombre
		// En tal caso, ad�ptalo para que funcione
		public static void main(String[] args) { 

			String email = pedirEmail();

			// ===== CREAR ALUMNOS =====
			Alumno a1 = new Alumno();
			a1.setDni("11111111A");
			a1.setEmail(email);
			a1.setFechaContratacion(LocalDate.of(2015, 5, 10));

			Alumno a2 = new Alumno();
			a2.setDni("22233344B");
			a2.setEmail("alumno2@empresa.com");
			a2.setFechaContratacion(LocalDate.of(2021, 3, 20));

			Alumno a3 = new Alumno();
			a3.setDni("33366688C");
			a3.setEmail("alumno3@empresa.com");
			a3.setFechaContratacion(LocalDate.of(2012, 8, 1));

			System.out.println("\nALUMNOS CREADOS: ");
			System.out.println("ALUMNO1 - " + a1);
			System.out.println("ALUMNO2 - " + a2);
			System.out.println("ALUMNO3 - " + a3);
			System.out.println();

			// ===== CREAR CURSOS =====
			CursoPresencial java = new CursoPresencial("Java", new BigDecimal("30"));
			java.setExperienciaMinima(5);
			java.setNumeroMaxPla(2);

			CursoPresencial sql = new CursoPresencial("SQL", new BigDecimal("25"));
			sql.setExperienciaMinima(3);

			CursoOnline spring = new CursoOnline("Spring", new BigDecimal("40"));
			spring.setTutorAsociado(false);

			CursoOnline docker = new CursoOnline("Docker", new BigDecimal("50"));
			docker.setTutorAsociado(true);

			// ===== CREAR ACADEMIA =====
			Academia academia = new Academia();
			academia.setNombre("Academia Tech");

			academia.getListaCurso().add(java);
			academia.getListaCurso().add(sql);
			academia.getListaCurso().add(spring);
			academia.getListaCurso().add(docker);

			// ===== MATRICULAR ALUMNOS =====
			System.out.println("MATRICULAR ALUMNOS");

			System.out.println("Cursos matriculados por ALUMNO1: " + academia.matricularAlumno(a1));
			System.out.println("Cursos matriculados por ALUMNO2: " + academia.matricularAlumno(a2));
			System.out.println("Cursos matriculados por ALUMNO3: " + academia.matricularAlumno(a3));

			System.out.println();

			// ===== COMPROBAR MATR�CULA =====
			System.out.println("�ALUMNO1 matriculado en Java? " + java.isMatriculado("11111111A"));
			System.out.println("�ALUMNO2 matriculado en Java? " + java.isMatriculado("22233344B"));
			System.out.println();

			// ===== CUOTA ALUMNO =====
			System.out.println("CUOTAS");
			System.out.println("Cuota ALUMNO1: " + academia.getCuotaAlumno("11111111A"));
			System.out.println("Cuota ALUMNO2: " + academia.getCuotaAlumno("22233344B"));
			System.out.println("Cuota ALUMNO3: " + academia.getCuotaAlumno("33366688C"));
			System.out.println();

			// ===== CURSO M�S BARATO =====
			Curso barato = academia.getCursoMasBarato(5);
			if (barato != null) {
				System.out.println("Curso m�s barato para experiencia m�nima 5: " + barato.getNombre());
			}

			System.out.println();

			// ===== BORRAR CURSOS VAC�OS =====
			Academia academia2 = new Academia();

			CursoPresencial python = new CursoPresencial("Python", new BigDecimal("35"));
			CursoOnline react = new CursoOnline("React", new BigDecimal("45"));
			CursoOnline angular = new CursoOnline("Angular", new BigDecimal("30"));

			academia2.getListaCurso().add(python);
			academia2.getListaCurso().add(react);
			academia2.getListaCurso().add(angular);

			// matriculamos un alumno en un curso
			python.matricularAlumno(a1);

			System.out.println("Cursos antes de borrar: " + academia2.getListaCurso().size());
			System.out.println("Borrados: " + academia2.borrarCursosVacios());
			System.out.println("Cursos despu�s: " + academia2.getListaCurso().size());

			System.out.println();

			// ===== ACADEMIA UNIVERSITARIA =====
			AcademiaUniversitaria premium = new AcademiaUniversitaria();
			premium.setSalaEstudio(true);
			premium.getListaCurso().add(java);
			premium.getListaCurso().add(docker);

			System.out.println("Cuota premium ALUMNO1: " + premium.getCuotaAlumno("11111111A"));

		}

	}


