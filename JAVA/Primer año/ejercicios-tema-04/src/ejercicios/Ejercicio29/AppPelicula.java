package ejercicios.Ejercicio29;

import java.util.ArrayList;
import java.util.List;

public class AppPelicula {

	public static void main(String[] args) {
		Actor a1 = new Actor();
		Actor a2 = new Actor();
		Actor a3 = new Actor();
		Actor a4 = new Actor();
		a1.setNombre("blas Blau");
		a1.setNacionalidad("España");
		a1.setAñoNacimiento(1983);
		a2.setNombre("Laura Pozo");
		a2.setNacionalidad("Italia");
		a2.setAñoNacimiento(1981);
		a3.setNombre("Marcel Cade");
		a3.setNacionalidad("Suiza");
		a3.setAñoNacimiento(2001);
		a4.setNombre("Violeta Volo");
		a4.setNacionalidad("Rusia");
		a4.setAñoNacimiento(1999);
		Director d1 =new Director();
		d1.setNombre("Sara Marea");
		d1.setNacionalidad("Portugal");
		d1.setAñoNacimiento(1994);
		Guionista g1 = new Guionista();
		Guionista g2 = new Guionista();
		g1.setNombre("Marc Smith");
		g1.setNacionalidad("Reino Unido");
		g1.setAñoNacimiento(1988);
		g2.setNombre("Cheng Shu");
		g2.setNacionalidad("China");
		g2.setAñoNacimiento(1977);
		Pelicula miPelicula = new Pelicula();
		miPelicula.setAñoDeEstreno(2027);
		miPelicula.setSuDirector(d1);
		miPelicula.setSuGuionista(g1);
		miPelicula.getListaDeActores().add(a1);
		miPelicula.getListaDeActores().add(a2);
		miPelicula.setTitulo("Do you know joe blas");
		Pelicula miPelicula2 = new Pelicula();
		miPelicula2.setAñoDeEstreno(2027);
		miPelicula2.setSuDirector(d1);
		miPelicula2.setSuGuionista(g2);
		miPelicula2.getListaDeActores().addAll(miPelicula.getListaDeActores());
		miPelicula2.getListaDeActores().add(a3);
		miPelicula2.getListaDeActores().add(a4);
		miPelicula2.setTitulo("Muerte en la sombra");
		System.out.println("Los Actores de la pelicula "+ miPelicula.getTitulo()+"son "+miPelicula.getListaDeActores());
		System.out.println("EL sueldo del  guionistas de la pelicula "+ miPelicula.getTitulo()+" es "+ miPelicula.getSuGuionista().getSueldo()+" y su nacionalidad es "+miPelicula.getSuGuionista().getNacionalidad()+".");
		miPelicula2.getListaDeActores().remove(2);
		miPelicula.getListaDeActores().add(a3);
		System.out.println("Los Actores de la película "+ miPelicula.getTitulo()+" son "+miPelicula.getListaDeActores()+" y los de la película "+ miPelicula2.getTitulo()+" son "+miPelicula2.getListaDeActores());
		
		
	}

}
