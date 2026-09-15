package ejercicios.Ejercicios01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicios01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			List<Integer> listaNumero = new ArrayList<>();
			do {
				try {
					System.out.println("Dime un número:");
					listaNumero.add(sc.nextInt());
				} catch (InputMismatchException e) {
					System.out.println("ERROR SOLO NUMEROS");
					sc.nextLine();
				}

			} while (!(listaNumero.contains(-1)));
			System.out.println("Sus números: ");
			for (Integer integer : listaNumero) {
				System.out.print(integer+" ");
			}
			
		} finally {
			sc.close();
		}
	}

}
