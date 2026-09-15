package ejercicios.Ejercicio38;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarritoCompra {
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;
	private Cliente miCliente;
	private List<Articulo> listaArticulo;

	public CarritoCompra(Cliente miCliente) {
		listaArticulo = new ArrayList<>();
		this.miCliente = miCliente;
		fechaCreacion = LocalDate.now();
		fechaModificacion = LocalDate.now();
		this.listaArticulo = new ArrayList<>();
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

	public List<Articulo> getListaArticulo() {
		return listaArticulo;
	}

	public BigDecimal getCantidad() {
		return BigDecimal.valueOf(listaArticulo.size());
	}

	public BigDecimal getTotal() {
		BigDecimal precio = BigDecimal.ZERO;
		for (Integer i = 0; i < listaArticulo.size(); i++) {
			precio.add(listaArticulo.get(i).getPrecio());

		}
		return precio;
	}

	public BigDecimal getPrecioMedio() {
		if (listaArticulo.size() != 0) {
			return getTotal().divide(getCantidad(),2, RoundingMode.HALF_DOWN);
		}
		return BigDecimal.ZERO;
	}

	public String getModificacionFormato() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return fechaModificacion.format(formato);
	}

	@Override
	public String toString() {
		return "CarritoComrpra [fecha de modificación=" + getModificacionFormato() + ", Cliente=" + miCliente
				+ "Cantidad de articulos=" + getCantidad() + ", Suma total a pagar=" + getTotal() + "]";
	}

	public void addArticulo(Articulo articulo) {
		listaArticulo.add(articulo);
		fechaModificacion = LocalDate.now();
	}

	public void borrarArticulo(Integer numero) {
		if (listaArticulo.size() != 0) {
			listaArticulo.remove(listaArticulo.get(numero));
		}
		fechaModificacion = LocalDate.now();
	}

	public void vaciarCesta() {
		if (listaArticulo.size() != 0) {
			for (Integer i = listaArticulo.size() - 1; i >= 0; i--) {
				listaArticulo.remove(listaArticulo.get(i));
			}
		}
		fechaModificacion = LocalDate.now();

	}

}
