package ejercicios.Ejercicio43;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio43 {

	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<>();
		List<String> separaPalabras = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String palabras = "",letra ="", palabrasCompletas="";
		do {
			System.out.print("Dime una palabra: ");
			palabras = sc.nextLine();
			if (!(palabras.contains("FIN"))) {
				separaPalabras.add(palabras);
			}

		} while (!(palabras.contains("FIN")));

		for (Integer i = 0; i < separaPalabras.size(); i++) {
			if (map.containsKey(separaPalabras.get(i).substring(0, 1))) {
				map.get(separaPalabras.get(i).substring(0, 1).toUpperCase()).add(separaPalabras.get(i));
			} else {
				List<String> lista2 = new ArrayList<>();
				lista2.add(separaPalabras.get(i));
				map.put(separaPalabras.get(i).substring(0, 1).toUpperCase(), lista2);
			}
		}
		do {
			System.out.println("Dime una letra: ");
			letra =sc.nextLine().toUpperCase();
			if (letra.contains("FIN")) {
				System.out.println("¡Gracias por jugar con nosotros! Bye");
				break;
			}
			palabrasCompletas="Hay "+map.get(letra).size()+ "palabras que empiezan por "+letra+":\n";
			for (int i = 0; i < map.get(letra).size(); i++) {
				palabrasCompletas+="\t>"+map.get(letra).get(i);
			}
			System.out.println(palabrasCompletas);
		} while (!(letra.contains("FIN")));
	}
	
}

