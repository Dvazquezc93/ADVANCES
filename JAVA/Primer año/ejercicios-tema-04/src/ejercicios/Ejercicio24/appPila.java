package ejercicios.Ejercicio24;

import java.util.Iterator;

public class AppPila {

	public static void main(String[] args) {
		Pila pilita = new Pila();
		pilita.añadirCadena("primero");
		pilita.añadirCadena("segundo");
		System.out.println(pilita);
		System.out.println("Sacamos a " +pilita.sacarCadena());
		System.out.println(pilita);
		pilita.añadirCadena("tercero");
		System.out.println(pilita);
		for (Integer i=0; i<= pilita.getTamaño();i++) {
			System.out.println("Sacamos a " +pilita.sacarCadena());
		}
		pilita.añadirCadena("cuarto");
		System.out.println(pilita);
	}

}
