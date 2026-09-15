package ejercicios.Ejercicio44;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppDiccionario {

	public static void main(String[] args) {
		Diccionario d1 =new Diccionario();
		List<String> separaPalabras = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String palabras = "";
		do {
			System.out.print("Dime una palabra: ");
			palabras = sc.nextLine();
			if (!(palabras.contains("FIN"))) {
				separaPalabras.add(palabras);
			}

		} while (!(palabras.contains("FIN")));
		d1.cargarDiccionario(separaPalabras);
		System.out.println(d1.imprimirPalabras("A"));
		d1.borrarDiccionario();

	}

}
