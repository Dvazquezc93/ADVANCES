package ejercicios.Ejercicio20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		// String mayus="";
		for (Integer i = 0; i < 5; i++) {
			System.out.println("****Gato" + (i + 1) + "****\nNombre:");
			lista.add(sc.nextLine());
		}
		System.out.println(lista);
		for (Integer i = 0; i < 5; i++) {
			// mayus= lista.get(i).substring(0,1).toUpperCase()+lista.get(i).substring(1);
			lista.set(i, lista.get(i).toUpperCase());

		}
		System.out.println(lista);
		if (lista.contains("")) {
			System.out.println("Hay alguna cadena vacia vacia ");
		} else {
			System.out.println("No hay alguna cadena vacia vacia ");
		}
		
		 for (Iterator<String> iterator =lista.iterator(); iterator.hasNext();) {
	 if (iterator.next().length()<6) {
		iterator.remove();
		 }
		
		
		System.out.println(lista);
	}

}
}
