package ejercicios.EjercicioPrueba;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Granja {
	private String Localidad;
	private List<Animal> listaAnimales;

	public Granja(String localidad) {
		Localidad = localidad;
		listaAnimales = new ArrayList<>();
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public void addAnimal(Animal animal) {
		listaAnimales.add(animal);
	}

	public List<Animal> getAnimalesNacimiento(Integer año) {
		List<Animal> animalesNacidos = new ArrayList<>();
		if (!(listaAnimales.isEmpty())) {
			for (Animal animal : listaAnimales) {
				Integer añoAnimal = animal.getFechaNacimiento().getYear();
				if (añoAnimal.equals(año)) {
					animalesNacidos.add(animal);
				}
			}
		}

		return animalesNacidos;
	}

	public BigDecimal getPesoTotal() {
		BigDecimal pesoTotal = BigDecimal.ZERO;
		if (!(listaAnimales.isEmpty())) {
			for (Animal animal : listaAnimales) {
				pesoTotal = pesoTotal.add(animal.getPeso());
			}
		}
		return pesoTotal.setScale(2, RoundingMode.HALF_UP);

	}

	public BigDecimal calcularPrecioVenta() {
		BigDecimal pesoVenta = BigDecimal.ZERO;
		if (!(listaAnimales.isEmpty())) {
			for (Animal animal : listaAnimales) {
				pesoVenta = pesoVenta.add(animal.precioTotalVenta());

			}
		}
		return pesoVenta;
	}
	public void venderAnimales() {
		if (!(listaAnimales.isEmpty())) {
			for (Iterator<Animal> iterator = listaAnimales.iterator(); iterator.hasNext();) {
				Animal animal =  iterator.next();
				if (animal.sePuedeVender()) {
					iterator.remove();
				}
				
			}
		}
	}

	@Override
	public String toString() {
		return "Granja de " + Localidad +" // "+listaAnimales.size()+" animales con "+ getPesoTotal()+" kilos.";
	}
}
