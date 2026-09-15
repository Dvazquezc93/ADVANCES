package ejercicios.Ejercicio42;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio42 {

	public static void main(String[] args) {
		Map<Integer, Integer> conteo = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		Integer key = 0;
		Integer contador = 1,contador2=1;
		do {
			System.out.print("Dime el número: ");
			key = sc.nextInt();
			contador2++;
			if (conteo.containsKey(key)) {
				contador= conteo.get(key);
				conteo.put(key, contador+1);
			} else {
				 contador = 1;
				 conteo.put(key, contador);
			}
		} while (!conteo.containsKey(0));
		System.out.println("Total números indicados: "+contador2+"\n Distribución:\n");
		for (Integer numero : conteo.keySet()) {
			System.out.println(">Número: "+numero+":"+conteo.get(numero)+" veces.");
		}
	
		sc.close();

	}

}
