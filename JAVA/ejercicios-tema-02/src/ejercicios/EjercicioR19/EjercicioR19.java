package ejercicios.EjercicioR19;

import java.util.Scanner;

public class EjercicioR19 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner (System.in);
		Integer select;
		do {
			System.out.println("****Menú****\n\t1. Pasar de euros a peseta.\n\t2. pasar a de pesetas a euros.\n\t3. Salir");
			 select = skynnet.nextInt();
			 
			if (select==1) {
				System.out.println("Cantidad en euros: ");
				Integer euros =skynnet.nextInt();
				System.out.println("Sus pesetas son: 3"+ euros * 166.386);
			}
			else if (select==2) {
				System.out.println("Cantidad en pesetas: ");
				Integer pesetas =skynnet.nextInt();
			System.out.println("Sus euros son: "+ pesetas / 166.386);
			}
		} while (select!=3);
		
		
			System.out.println("ADIOOOOS");
		
		skynnet.close();
	}

}
