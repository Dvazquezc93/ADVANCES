package ejercicios.ejercicioR5;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Coche {
	protected String matricula;
	protected LocalDate fechaEntrada;
	protected Cliente cliente;

	public Coche(String matricula, Cliente cliente) {

		this.matricula = matricula;
		fechaEntrada = LocalDate.now();
		this.cliente = cliente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public BigDecimal getPago() {
		BigDecimal pago = new BigDecimal (10.75);
		Period periodo = fechaEntrada.until(LocalDate.now());
		return pago.multiply(BigDecimal.valueOf(periodo.getDays()));
	}	
	
}
