package ejercicios.Ejercicio27;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
	private String nombre;
	private Jugador capitan;
	private List<Jugador> listJugadores;
	private static String competicion;
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		listJugadores = new ArrayList<>();
	}

	public static String getCompeticion() {
		return competicion;
	}

	public static void setCompeticion(String competicion) {
		Equipo.competicion = competicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Jugador getCapitan() {
		return capitan;
	}

	public void setCapitan(Jugador jugador) {
		this.capitan =jugador;
	}

	public List<Jugador> getListJugadores() {
		return listJugadores;
	}

	public void setListJugadores(List<Jugador> listJugadores) {
		this.listJugadores = listJugadores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return  nombre + " - capitan: " + capitan + ", listJugadores: [" + listJugadores + " ]";
	}
	
}
