package ejercicios.Ejercicio03;

import ejercicios.Ejercicio02.ConsoleInOut;
import ejercicios.Ejercicio03.Libro;

public class app {
	public static void main(String[] args) {
		ConsoleInOut skynnet = new ConsoleInOut();
		String titulo = skynnet.readString("¿Cual es el titulo de su libro?");
		String autor = skynnet.readString("¿Cual es el autor de su libro?");
		Integer numeroPaginas = skynnet.readInteger("¿Cuantas páginas tiene tu libro?");
		Libro miLibro = new Libro(titulo, autor, numeroPaginas);
		System.out.println("El titulo es: " + miLibro.getTitulo() + "\n El autor es: " + miLibro.getAutor()
				+ "\n El número de paginas: " + miLibro.getTotalPaginas()+"\n");
		Integer procesoLibro = 0;
		do {
			procesoLibro = skynnet.readInteger(
					"¿Cómo vas con el libro?\r\n1. He avanzado \r\n" + "2. He retrocedido \r\n" + "3. He abandonado ");
			if (procesoLibro == 1) {
				Integer sumarPaginas = miLibro.leer(skynnet.readInteger("¿Cuantas paginas has leido?"));
				System.out.println("Su porcentaje de lectura es " + miLibro.progreso() + "%");
			}
			if (procesoLibro == 2) {
				Integer restarPaginas = miLibro.retroceder(skynnet.readInteger("¿Cuantas paginas has leido?"));
				System.out.println("Su porcentaje de lectura es " + miLibro.progreso() + " %.");
			}
		} while (procesoLibro != 3);
		System.out.println("****MENUDO LOSER****");
		skynnet.close();
	}

}
