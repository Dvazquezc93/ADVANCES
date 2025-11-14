package ejercicios.Ejercicio04;

import java.util.Scanner;

public class Ejercicio04 {
	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		
		System.out.println("dime un numero: ");
		Integer numero =skynnet.nextInt();
		Integer suma = 0;
		
		do {
			System.out.println("dime un numero: ");
		    numero =skynnet.nextInt();
		    suma = numero + suma;
		   
		    
		
		} while (numero !=0);
		System.out.println( "su suma es "+ suma);
		skynnet.close();
	
		}

		}
