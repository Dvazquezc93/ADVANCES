package ejercicios.EjerciciosA01;


import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class EjerciciosA01 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		Random ale1 = new Random();
		System.out.println("¿Cuantas tiradas de dados vas a hacer?");
		Integer tira1 = skynnet.nextInt();
		Integer[] arra1 = new Integer[tira1];
		Integer[] arra2 = new Integer[tira1];
		Integer[] arra3 = new Integer[11];
		Integer tira2 = 2;

		for (Integer i = 1; i < tira1; i++) {
			Integer ale2 = ale1.nextInt(1, 7);
			arra1[i] = ale2;
		}
		for (Integer i = 1; i < tira1; i++) {
			Integer ale2 = ale1.nextInt(1, 7);
			arra2[i] = ale2;
		}
		for (Integer e = 0; e <= 9; e++) {
			Integer cont2 = 0;
			for (Integer i = 0; i < arra3.length; i++) {

				if ((arra1[i] + arra2[i]) == tira2) {
					cont2++;
				}
				arra3[e] =  (cont2 / tira1);
				tira2++;
			}
		for (Integer i = 0; i < arra3.length; i++) {
			System.out.println("El porcentaje de que salga el numero " +tira2+ " es "+arra3[i]);
			tira2++;
			
		}
			
			
		
		}
		skynnet.close();
	}
}
