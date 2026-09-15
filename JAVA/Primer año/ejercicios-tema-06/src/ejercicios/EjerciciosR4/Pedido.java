package ejercicios.EjerciciosR4;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pedido {
	private Integer numero;
	private LocalDate fechaPedido;
	private Integer cantidadArticulos;
	private BigDecimal precio;
	private Boolean entregado;

	public Pedido(Integer numero) {
		this.numero = numero;
		this.entregado = false;
		this.fechaPedido = LocalDate.now();
		this.precio = BigDecimal.ZERO;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Integer getCantidadArticulos() {
		return cantidadArticulos;
	}

	public void setCantidadArticulos(Integer cantidadArticulos) {
		this.cantidadArticulos = cantidadArticulos;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Boolean getEntregado() {
		return entregado;
	}

	public void setEntregado(Boolean entregado) {
		this.entregado = entregado;
	}

	public LocalDate getFechaEntregaPrevista() {
		return getFechaPedido().plusDays(7);
	}

	public BigDecimal getImporteTotal() throws EstadoIncorrectoException {
		if (entregado) {
			throw new EstadoIncorrectoException("El pedido ya ha sido entregado");
		} else if (getFechaEntregaPrevista().compareTo(fechaPedido) < 0) {
			return getPrecio();
		}
		return getPrecio().multiply(BigDecimal.valueOf(1.10));
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat formatoB = new DecimalFormat("#,###.00 €");
		return numero + " // " + fechaPedido.format(formato) + " > " + formatoB.format(precio) + " (CANTIDAD "
				+ cantidadArticulos + ")";

	}

}
