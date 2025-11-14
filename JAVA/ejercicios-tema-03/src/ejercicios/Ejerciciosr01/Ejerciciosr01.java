package ejercicios.Ejerciciosr01;

import java.util.Iterator;
import java.util.Scanner;

public class Ejerciciosr01 {
	public static void main(String[] args) {
		Integer[] listaNotas = new Integer[] { 7, 9, 8, 4, 0, 6, 3, 4, 1, 7, 3, 1, 9, 10 };
		Integer cont1 = 0, cont2 = 0, cont3=0;
		for (Integer not1 : listaNotas) {
			if (not1 < 5) {
				cont1++;
			}
			if (not1 >= 5) {
				cont2++;
			}
		}
		System.out.println("Han suspendido " + cont1 + " alumnos y han aprobado " + cont2 + " alumnos.");
		Integer max1= listaNotas[0],min1=listaNotas[0];
		for (Integer not1 : listaNotas) {
			if (not1>max1) {
				max1=not1;
			}
			if (not1<max1) {
				min1=not1;
			}
		}
		
		System.out.println("La nota mayor de los alumnos es "+max1+" y la nota menor es "+min1);
		Scanner skynnet =new Scanner(System.in);
		System.out.println("¿Que nota buscas?");
		Integer not2 = skynnet.nextInt();
		for (Integer not1 : listaNotas) {
			if (not2==not1) {
				cont3++;
			}
			
		}
		System.out.println("Hay "+cont3+" alumnos con la nota "+not2);
		skynnet.close();
	}
}
