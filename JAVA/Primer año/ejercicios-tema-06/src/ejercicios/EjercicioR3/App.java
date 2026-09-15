package ejercicios.EjercicioR3;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
		Libreria libre = new Libreria();
		solicitarLibreria(sc, libre);
		LibreriaService ls = new LibreriaService();
		for (Libro libro : libre.getLibrosBaratos()) {
			try {
				ls.insertarLibroNuevo(libro);
			} catch (LibroException e) {
				System.out.println(e.getMessage());
			}
		}
		DecimalFormat formato = new DecimalFormat("#,###.00 €");
		System.out.println("Todo ok");
		System.out.println("Su precio medio es "+formato.format(libre.getPrecioMedio()));
		System.out.println("Sus tasación final es "+formato.format(libre.getTasacionCompleta()));
		
		}
	}

	private static void solicitarLibreria(Scanner sc, Libreria libre) {
		libre.setNombre("Páginas desiertas");
		String continues = "";
		do {
			Libro l = new Libro();
			System.out.println("Dime ISBN, TITULO,AUTOR y PRECIO separados por punto y coma.");
			String datosLibro = sc.nextLine();
			String[] arrayDatos = datosLibro.split(";");
			l.setIsbn(arrayDatos[0]);
			l.setTitulo(arrayDatos[1]);
			l.setAutor(arrayDatos[2]);
			l.setPrecio(new BigDecimal(arrayDatos[3]));
			libre.getMapaLibro().put(l.getIsbn(), l);
			System.out.println("Quieres añadir otro libro?");
			continues = sc.nextLine();
		} while (!continues.equalsIgnoreCase("fin"));
	}

}
