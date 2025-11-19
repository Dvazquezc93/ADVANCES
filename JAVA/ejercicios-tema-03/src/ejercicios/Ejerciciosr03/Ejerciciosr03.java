package ejercicios.Ejerciciosr03;

import java.util.Iterator;

public class Ejerciciosr03 {

	public static void main(String[] args) {
		Integer[] listaNotas = new Integer[] { 7, 9, 8, 4, 0, 6, 3, 4, 1, 7, 3, 1, 9, 10 };
		for (Integer i=0;i<listaNotas.length;i++) {
			if (i%2==0) {
				listaNotas[i]=listaNotas[i]*2;
			}
			
		}
		System.out.print("Lista de notas: ");
	    for (Integer not1 : listaNotas) {
	    	
			System.out.print(not1+" ");
		}
	}

}
