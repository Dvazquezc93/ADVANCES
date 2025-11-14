package ejercicios.EjercicioR23;


import java.util.Random;
import java.util.Scanner;

public class EjercicioR23 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner (System.in);
		Random num1 = new Random();
		System.out.println("Cuantas veces lanzamos el dado:");
		Integer intento1 = skynnet.nextInt();
		for (Integer num2=1; num2<=intento1;num2++) {
			Integer num3= num1.nextInt(1,7);
			System.out.println(num3);
			
		}
		skynnet.close();

	}

}
