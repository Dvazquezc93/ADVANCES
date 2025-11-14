package ejercicios.ejercicioR1;

import java.util.Scanner;

public class EjercicioR1 {
	public static final Double PI =3.14159265358979323842;
	
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Digame el radio de un circulo");
		Double radio= skynnet.nextDouble();
		Double circunferencia= PI*radio;
		Double area = 2*PI*radio;
		

		System.out.println("Su circunferencia es " +circunferencia + " y su area es "+ area);
		skynnet.close();
		
		
	}

}
