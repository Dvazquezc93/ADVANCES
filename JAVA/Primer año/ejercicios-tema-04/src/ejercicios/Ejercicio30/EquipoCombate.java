package ejercicios.Ejercicio30;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;;

public class EquipoCombate {
	private List<Personaje> listaDePersonaje;

	public EquipoCombate() {
		listaDePersonaje = new ArrayList<>();
	}

	public Integer getVidaEquipo() {
		Integer vidaEquipo = 0;
		for (Integer i = 0; i < listaDePersonaje.size(); i++) {
			vidaEquipo += listaDePersonaje.get(i).getVida();
		}
		return vidaEquipo;
	}

	public void añadirPersonaje(Personaje personaje) {
		if (listaDePersonaje.size() < 5 && !listaDePersonaje.contains(personaje)) {
			listaDePersonaje.add(personaje);

		}
		

	}

	@Override
	public String toString() {
		return "EquipoCombate [listaDePersonaje=" + listaDePersonaje + "]";
	}
}
