package ejercicios.Ejercicio35;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio35 {
	public static void main(String[] args) {
		Set<String> lista = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		// String mayus="";
		for (Integer i = 0; i < 5; i++) {
			System.out.println("****Gato" + (i + 1) + "****\nNombre:");
			lista.add(sc.nextLine());
		}
		System.out.println(lista);
		Set<String> mayus = new HashSet<>();
		for (String string : lista) {
			mayus.add(string.toUpperCase());
		}
		lista=mayus;
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
		
		
		
	}
		 
}
}
