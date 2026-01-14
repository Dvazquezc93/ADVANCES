package ejercicios.Ejercicio02;

import java.util.Scanner;

import ejercicios.Ejercicio04.Alumno;

public class ConsoleInOut {
	private Scanner skynnet;

	public ConsoleInOut() {
		skynnet = new Scanner(System.in);
	}

	public void close() {
		skynnet.close();
	}

	public void write(String phraseUser) {
		System.out.println(phraseUser);
	}

	public Integer readInteger(String phraseUser) {
		write(phraseUser);
		Integer numberUser = skynnet.nextInt();
		skynnet.nextLine();
		return numberUser;
	}

	public void readInteger(String phraseUser, Integer numberMax, Integer numberMin, Integer numberUser) {
		do {
			numberUser = skynnet.nextInt();
		} while (numberUser >= numberMin || numberUser <= numberMax);
		skynnet.nextLine();
	}

	public Double readDouble(String phraseUser) {
		write(phraseUser);
		Double numberUser = skynnet.nextDouble();
		skynnet.nextLine();
		return numberUser;
	}

	public void readDouble(String phraseUser, Double numberMax, Double numberMin, Double numberUser) {
		do {
			numberUser = skynnet.nextDouble();
		} while (numberUser >= numberMin || numberUser <= numberMax);
		skynnet.nextLine();
	}

	public String readString(String phraseUser) {
		write(phraseUser);
		String phraseNoEmpty ="";
		do {
			phraseNoEmpty = skynnet.nextLine();
		} while (phraseNoEmpty.isEmpty());
		return phraseNoEmpty;
	}

	public void waitEnter() {
		write("Pulse ENTER para continuar");
		skynnet.nextLine();
	}

	public Boolean isContinue() {
		Boolean selectUser = true;
		String phraseUser = "";
		do {
			write("¿Desea continuar (S/N)?");
			phraseUser = skynnet.nextLine();
			if (phraseUser.equalsIgnoreCase("s")) {
				selectUser = true;
			}
			if (phraseUser.equalsIgnoreCase("n")) {
				selectUser = false;
			}
		} while (!(phraseUser.equalsIgnoreCase("s")) && !(phraseUser.equalsIgnoreCase("n")));
		return selectUser;
	}

}
