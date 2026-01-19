package ejercicios.Ejercicio18;

import java.util.Scanner;

public class appReloj {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Reloj[] arraReloj = new Reloj[2];
		String formato24Horas = "", repetirHora;
		do {

			for (Integer i = 0; i < arraReloj.length - 1; i++) {
				arraReloj[i] = new Reloj();
				System.out.println(arraReloj[i]);
				do {
					System.out.println("****Reloj " + (i + 1) + "****\n¿Que hora es?");
					Integer hora = sc.nextInt();
					System.out.println("¿Cuantos minutos?");
					Integer minuto = sc.nextInt();
					System.out.println("¿Cuantos segundos?");
					Integer segundo = sc.nextInt();
					arraReloj[i].ponerEnHora(hora, minuto, segundo);
					if (arraReloj[i].check() == false) {
						System.out.println("ERROR EN LA HORA.");
					}
				} while (!(arraReloj[i].check()));
				sc.nextLine();
				do {
					System.out.println("¿Es formato 24 horas?");
					formato24Horas = sc.nextLine();
					if (formato24Horas.equalsIgnoreCase("si")) {
						arraReloj[i].setFormato24Horas(true);
					}
					if (formato24Horas.equalsIgnoreCase("no"))
						arraReloj[i].setFormato24Horas(false);
				} while (!(formato24Horas.equalsIgnoreCase("si")) && !(formato24Horas.equalsIgnoreCase("no")));
				System.out.println(arraReloj[i]);
			}
			System.out.println("¿Quiere cambiar la hora?");
			repetirHora = sc.nextLine();
		} while (repetirHora.equalsIgnoreCase("si"));

		for (Integer i = 1; i < arraReloj.length; i++) {
			arraReloj[i] = new Reloj(17, 16, 15);
			System.out.println("****Reloj " + (i + 1) + "****\n" + arraReloj[i]);
		}
		if (arraReloj[0].equals(arraReloj[1])) {
			System.out.println("Sus relojes son iguales.");
		} else {
			System.out.println("Sus relojes no son iguales.");
		}
	}

}