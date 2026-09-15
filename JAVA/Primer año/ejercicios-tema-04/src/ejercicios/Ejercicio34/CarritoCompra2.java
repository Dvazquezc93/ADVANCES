package ejercicios.Ejercicio34;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CarritoCompra2 {
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;
	private Cliente miCliente;
	private Set<Articulo> listaArticulo;

	public CarritoCompra2(Cliente miCliente) {
		this.miCliente = miCliente;
		fechaCreacion = LocalDate.now();
		fechaModificacion = LocalDate.now();
		this.listaArticulo = new HashSet<>();
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDate getFechaModificacion() {
		return fechaModificacion;
	}

	public Cliente getMiCliente() {
		return miCliente;
	}

	public Set<Articulo> getListaArticulo() {
		return listaArticulo;
	}

	public Integer getCantidad() {
		return listaArticulo.size();
	}

	public Double getTotal() {
		Double precio = 0.0;
		for (Articulo articulo : listaArticulo) {
			precio+=articulo.getPrecio();
		}
		return precio;
	}

	public Double getPrecioMedio() {
		if (listaArticulo.size() != 0) {
			return getTotal() / getCantidad();
		}
		return 0.0;
	}

	public String getModificacionFormato() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return fechaModificacion.format(formato);
	}

	@Override
	public String toString() {
		return "CarritoComrpra [fecha de modificación=" + getModificacionFormato() + ", Cliente=" + miCliente
				+"\n Cantidad de articulos=" + getCantidad() + ", Suma total a pagar=" + getTotal() + "]";
	}

	public void addArticulo(Articulo articulo) {
		listaArticulo.add(articulo);
		fechaModificacion = LocalDate.now();
	}

	public void borrarArticulo(Articulo articulo) {
		if (listaArticulo.size() != 0) {
			listaArticulo.remove(articulo);
		}
		fechaModificacion = LocalDate.now();
	}

	public void vaciarCesta() {
		listaArticulo.clear();
		fechaModificacion = LocalDate.now();
	}

}
