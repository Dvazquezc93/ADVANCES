package ejercicios.EjercicioR26;

import java.util.Random;
import java.util.Scanner;

public class EjercicioR26 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Random ale1 = new Random();

		String select1, sino1;
		Integer ale2, win1 = 0, lost1 = 0, tabla1 = 0;
		do {
			System.out.println("Piedra, papel, tijera… un, dos, tres… ya!!");
			select1 = skynnet.nextLine();
			ale2 = ale1.nextInt(1, 4);
			if (select1.equalsIgnoreCase("piedra") && ale2 == 1) {
				System.out.println("Piedra, empate.");
				tabla1++;
			} else if (select1.equalsIgnoreCase("piedra") && ale2 == 2) {
				System.out.println("papel, has perdido.");
				lost1++;
			} else if (select1.equalsIgnoreCase("piedra") && ale2 == 3) {
				System.out.println("Tijera, has ganado");
				win1++;
			} else if (select1.equalsIgnoreCase("papel") && ale2 == 1) {
				System.out.println("Piedra, has ganado.");
				win1++;
			} else if (select1.equalsIgnoreCase("papel") && ale2 == 2) {
				System.out.println("Papel, empate.");
				tabla1++;
			} else if (select1.equalsIgnoreCase("papel") && ale2 == 3) {
				System.out.println("Tijera, has perdido.");
				lost1++;
			} else if (select1.equalsIgnoreCase("tijera") && ale2 == 1) {
				System.out.println("Piedra, has perdido.");
				lost1++;
			} else if (select1.equalsIgnoreCase("tijera") && ale2 == 2) {
				System.out.println("Papel, has ganado.");
				win1++;
			} else if (select1.equalsIgnoreCase("tijera") && ale2 == 3) {
				System.out.println("tijera, empate.");
				tabla1++;
			} else {
				System.out.println("error");
			}
			System.out.println("¿Quieres realizar otra ronda?");
			sino1 = skynnet.nextLine();
			if (!sino1.equalsIgnoreCase("si") && !sino1.equalsIgnoreCase("no")) {
				do {
					System.out.println("error,¿Quiere realizar otra ronda?");
					sino1 = skynnet.nextLine();

				} while (!sino1.equalsIgnoreCase("si") && !sino1.equalsIgnoreCase("no"));
			}

		} while (!sino1.equalsIgnoreCase("no"));
		System.out.println(
				"Has ganado " + win1 + " veces, has perdido " + lost1 + " veces y has empatado " + tabla1 + " veces.");
		skynnet.close();
	}
}
