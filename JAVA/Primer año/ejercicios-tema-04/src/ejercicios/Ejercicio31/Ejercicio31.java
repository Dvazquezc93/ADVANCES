package ejercicios.Ejercicio31;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicio31 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LocalDate fecha = null;
		Boolean fechaCorrecta = false;
		do {
			System.out.println("¿En que dia naciste?");
			Integer dia = sc.nextInt();
			System.out.println("¿En que mes naciste?");
			Integer mes = sc.nextInt();
			System.out.println("¿En que año naciste?");
			Integer año = sc.nextInt();
			if (dia <= 31 && mes <= 12 && año <= LocalDate.now().getYear()) {
				fechaCorrecta = true;
				fecha = LocalDate.of(año, mes, dia);
			}
		} while (!fechaCorrecta);
		Boolean bisiesto = fecha.isLeapYear();
		if (bisiesto) {
			System.out.println("Su año de nacimiento es bisiesto");
		} else {
			System.out.println("Su año de nacimiento no es bisiesto");
		}

		;
		System.out.println("Su dia de nacimiento es " + fecha.getDayOfWeek());
		System.out.println("tiene " + (LocalDate.now().getYear() - fecha.getYear()) + " años.");
		LocalDate futuro = fecha.plusYears(100);
		Period periodo = LocalDate.now().until(futuro);
		System.out.println("Le queda " + periodo.getDays() + " dias "
				+ periodo.getMonths() + " meses y "
				+ periodo.getYears()+ " años.");
		LocalTime hora = LocalTime.now();
		DateTimeFormatter horaforma =DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaFinal =hora.format(horaforma);
		System.out.println(horaFinal);
		sc.close();

	}
}
