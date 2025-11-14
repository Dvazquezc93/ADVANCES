package ejercicios.EjercicioR25;

import java.util.Random;
import java.util.Scanner;

public class EjercicioR25 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner (System.in);
		Random ale1 = new Random();
		System.out.println("Piedra, papel, tijera… un, dos, tres… ya!!");
		String select1 = skynnet.nextLine();
		Integer ale2 = ale1.nextInt(1,4);
		if (select1.equalsIgnoreCase("piedra")&&ale2==1) {
			System.out.println("Piedra, empate.");
		}
		else if (select1.equalsIgnoreCase("piedra")&&ale2==2) {
			System.out.println("papel, has perdido.");
		}
		else if (select1.equalsIgnoreCase("piedra")&&ale2==3) {
			System.out.println("Tijera, has ganado");
		}
		else if (select1.equalsIgnoreCase("papel")&&ale2==1) {
			System.out.println("Piedra, has ganado.");
		}
		else if (select1.equalsIgnoreCase("papel")&&ale2==2) {
			System.out.println("Papel, empate.");
		}
		else if (select1.equalsIgnoreCase("papel")&&ale2==3) {
			System.out.println("Tijera, has perdido.");
		}
		else if (select1.equalsIgnoreCase("tijera")&&ale2==1) {
			System.out.println("Piedra, has perdido.");
		}
		else if (select1.equalsIgnoreCase("tijera")&&ale2==2) {
			System.out.println("Papel, has ganado.");
		}
		else if (select1.equalsIgnoreCase("tijera")&&ale2==3) {
			System.out.println("tijera, empate.");
		}
		skynnet.close();
	}

}
