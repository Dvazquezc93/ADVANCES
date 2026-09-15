package ejercicios.Ejercicio23;

import ejercicios.Ejercicio23.ColasCadenas;

public class AppColasCadenas {

	public static void main(String[] args) {
		ColasCadenas colitas = new ColasCadenas();
		colitas.añadirCadena("primero");
		colitas.añadirCadena("segundo");
		System.out.println(colitas);
		System.out.println("Sacamos a " +colitas.sacarCadena());
		System.out.println(colitas);
		colitas.añadirCadena("tercero");
		System.out.println("Sacamos a " +colitas);
		for (Integer i=0; i<= colitas.getTamaño();i++) {
			System.out.println("Sacamos a " +colitas.sacarCadena());
		}
		colitas.añadirCadena("cuarto");
		System.out.println(colitas);
		
		

	}

}
