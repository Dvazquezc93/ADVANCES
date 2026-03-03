package ejercicios.EjercicioR4;

import java.time.LocalDate;

public class AppLibreria {
public static void main(String[] args) {
	Libreria li1 =new Libreria();
	li1.setDireccion("Avda. de los sueños perdidos, 89");
	li1.setNumeroTelefono(954696954);
	Fisico f1 = new Fisico();
	Fisico f2 = new Fisico();
	f1.setTitulo("Canción de hielo y fuego");
	f1.setAutor("George R. R. Martin");
	f1.setFechaEdicion(LocalDate.of(1996,8,1));
	f1.setNumeroPaginas(800);
	f1.setAncho(16);
	f1.setAlto(24);
	f1.setPeso(1130);
	f2.setTitulo("El Silmarillion");
	f2.setAutor("J. R. R. Tolkien");
	f2.setFechaEdicion(LocalDate.of(1977,9,15));
	f2.setNumeroPaginas(540);
	f2.setAncho(12);
	f2.setAlto(19);
	f2.setPeso(296);
	Libro l1 = new Libro();
	l1.setTitulo("Marvel Saga TPB. El Asombroso Spiderman 14 :Un nuevo día");
	l1.setAutor("Dan Slott");
	l1.setFechaEdicion(LocalDate.of(2008,1,15));
	l1.setNumeroPaginas(232);
	Libro l2 = new Libro();
	l2.setTitulo("Spiderman: De vuelta al negro");
	l2.setAutor("Ron Garney");
	l2.setFechaEdicion(LocalDate.of(2008,7,7));
	l2.setNumeroPaginas(128);
	li1.getListaLibros().add(f1);
	li1.getListaLibros().add(f2);
	li1.getListaLibros().add(l1);
	li1.getListaLibros().add(l2);
	System.out.println("El libro mas antiguo es: "+li1.obteberLibroMasAntiguo());
	System.out.println("El peso total de los libros es: "+li1.ObtenerPesoTotalDeLibros());
	System.out.println("El número de páginas medio es: "+li1.ObtenerNumPaginasMedio());
	
}
}
