package ejercicios.ejercicioR5;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Garaje {
	protected Map<Integer, Coche> cochesAparcados;

	public Garaje(Map<Integer, Coche> cochesAparcados) {

		cochesAparcados = new HashMap<>();
	}

	public Map<Integer, Coche> getCochesAparcados() {
		return cochesAparcados;
	}

	public void setCochesAparcados(Map<Integer, Coche> cochesAparcados) {
		this.cochesAparcados = cochesAparcados;
	}

	public Boolean isPlazaOcupada(Integer plaza) {
		return cochesAparcados.get(plaza) != null;
	}

	public Coche getCocheCliente() throws GarajeExcepion {
		Coche cocheAntiguo = null;
		for (Coche coche : cochesAparcados.values()) {
			if (cocheAntiguo == null) {
				cocheAntiguo = coche;
			}
			if (cocheAntiguo.getFechaEntrada().isBefore(coche.getFechaEntrada())) {
				cocheAntiguo= coche;
			}
		}
		if (cocheAntiguo == null) {
			throw new GarajeExcepion("NO HAY COCHES APARCADOS");
		}
		return cocheAntiguo;
	}
	public List<Coche> getCochesClientes(String dni) throws GarajeExcepion {
		List<Coche> cocheCliente = new ArrayList<>();
		for (Coche coche : cochesAparcados.values()) {
			if (coche.getCliente().getDni().equals(dni)) {
				cocheCliente.add(coche);
			}
		}
		if (cocheCliente.isEmpty()) {
			throw new GarajeExcepion("NO HAY COCHES APARCADOS CON ESE DNI");
		}
		return cocheCliente;
	}
	public BigDecimal getCuentacliente(String dni)  {
		BigDecimal cuentaCliente = BigDecimal.ZERO;
		for (Coche coche : cochesAparcados.values()) {
			if (coche.getCliente().getDni().equals(dni)) {
				cuentaCliente = cuentaCliente.add(coche.getPago());
			}
		}
		return cuentaCliente;
	}
	public Integer borrarCochesAntiguos(LocalDate fecha) {
		Integer contador = 0;
		for (Iterator iterator = cochesAparcados.keySet().iterator(); iterator.hasNext();) {
			Integer type = (Integer) iterator.next();
			if (cochesAparcados.get(type).getFechaEntrada().isBefore(fecha)) {
				iterator.remove();
				contador++;
			}
			
		}
		return contador;
	}
}
