package ejercicios.Ejercicio29;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	protected Integer añoDeEstreno;
	protected String titulo;
	protected List<Actor> listaDeActores;
	protected Guionista suGuionista;
	protected Director suDirector;

	public Pelicula() {
		listaDeActores = new ArrayList<>();
	}

	public Integer getAñoDeEstreno() {
		return añoDeEstreno;
	}

	public void setAñoDeEstreno(Integer añoDeEstreno) {
		this.añoDeEstreno = añoDeEstreno;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Actor> getListaDeActores() {
		return listaDeActores;
	}

	public void setListaDeActores(List<Actor> listaDeActores) {
		this.listaDeActores = listaDeActores;
	}

	public Guionista getSuGuionista() {
		return suGuionista;
	}

	public void setSuGuionista(Guionista suGuionista) {
		this.suGuionista = suGuionista;
	}

	public Director getSuDirector() {
		return suDirector;
	}

	public void setSuDirector(Director suDirector) {
		this.suDirector = suDirector;
	}

	@Override
	public String toString() {
		return "Pelicula [añoDeEstreno=" + añoDeEstreno + ", titulo=" + titulo + ", listaDeActores=" + listaDeActores
				+ ", suGuionista=" + suGuionista + ", suDirector=" + suDirector + "]";
	}

}
