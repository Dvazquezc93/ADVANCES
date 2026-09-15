package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObraNueva {
	protected String direccion;
	protected LocalDate fechaInicio;
	protected LocalDate fechaFinEstimada;
	protected BigDecimal presupuesto;
	protected List<Obrero> listaObreros;

	public ObraNueva(String direccion) {
		super();
		this.direccion = direccion;
		listaObreros = new ArrayList<>();
		presupuesto = BigDecimal.ZERO;
		fechaInicio = LocalDate.now();
		fechaFinEstimada = fechaInicio.plusMonths(6);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinEstimada() {
		return fechaFinEstimada;
	}

	public void setFechaFinEstimada(LocalDate fechaFinEstimada) {
		this.fechaFinEstimada = fechaFinEstimada;
	}

	public BigDecimal getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(BigDecimal presupuesto) {
		this.presupuesto = presupuesto;
	}

	public List<Obrero> getListaObreros() {
		return listaObreros;
	}

	public void setListaObreros(List<Obrero> listaObreros) {
		this.listaObreros = listaObreros;
	}

	public Boolean estaEnRetraso() {
		return fechaFinEstimada.isBefore(LocalDate.now());
	}

	public Integer getDuracionEstimada() {
		Period periodo = fechaInicio.until(fechaFinEstimada);
		return periodo.getYears() * 12 + periodo.getMonths();
	}

	public Integer getDuracionReal() {
		Period periodo = fechaInicio.until(LocalDate.now());
		return periodo.getYears() * 12 + periodo.getMonths();
	}

	public BigDecimal getPenalizacion() {
		if (!estaEnRetraso()) {
			return BigDecimal.ZERO;
		}
		if (getDuracionEstimada() > 12) {
			return getPresupuesto().multiply(BigDecimal.valueOf(0.30));
		}
		return getPresupuesto().multiply(BigDecimal.valueOf(0.20));
	}

	public BigDecimal getPresupuestoDisponible() throws ObraEstadoException {
		BigDecimal sueldoObreros = BigDecimal.ZERO;
		for (Obrero obrero : listaObreros) {
			sueldoObreros = sueldoObreros.add(obrero.getSueldoFinal());
		}
		BigDecimal presupuestoDisponible = getPresupuesto().subtract(getPenalizacion()).subtract(sueldoObreros);

		if (presupuestoDisponible.compareTo(BigDecimal.ZERO) < 0) {
			throw new ObraEstadoException("El presupuesto se ha excedido " + presupuestoDisponible.plus());
		}
		return presupuestoDisponible;
	}

	public Map<String, List<Obrero>> getObrerosPorEspecialidad() throws ObraEstadoException {
		if (listaObreros.isEmpty()) {
			throw new ObraEstadoException("La obra no tiene ningún obrero");
		}
		Map<String, List<Obrero>> mapaObreros = new HashMap<>();
		for (Obrero obrero : listaObreros) {
			if (obrero.getEspecialidad().isEmpty()||obrero.getEspecialidad().equals(null)) {
				throw new ObraEstadoException("Hay un obrero sin especialidad.");
			}
			mapaObreros.get(obrero.getEspecialidad()).add(obrero);
		}
		return mapaObreros;
	}

}
