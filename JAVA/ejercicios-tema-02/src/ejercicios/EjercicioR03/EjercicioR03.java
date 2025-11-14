package ejercicios.EjercicioR03;

import java.util.Scanner;

public class EjercicioR03 {

	public static void main(String[] args) {
		Scanner skynnet =new Scanner (System.in);
		Integer numero;
		do {
			System.out.println("*** MENU ***");
			System.out.println("1.Abrir");
			System.out.println("2.Guardar");
			System.out.println("3.Modificar");
			System.out.println("4.Salir");
			numero = skynnet.nextInt();
			if (numero==1) {
				System.out.println("puerta abierta, ha salido la bestia.");
				}
			else if (numero ==2) {
				System.out.println("puerta cerrada, la bestia esta encerrada.");
			}
			else if (numero==3) {
				System.out.println("puerta modificada, la bestia ha rugido.");
				}
			else if (numero>4) {
				System.out.println("error, la bestia te ataca.");
			}
			
		} while (numero!=4);
		System.out.println("Bye, bye");
		skynnet.close();
		
	}

}
