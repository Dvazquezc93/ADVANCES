package ejercicios.EjercicioR8;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Parking {
	private Map<LocalDate, Automovil> mapaVehiculo;

	public Parking() {

		mapaVehiculo = new HashMap<>();
	}

	public Boolean entrar(Automovil automovil) {
		if (automovil.getTonelaje().compareTo(new BigDecimal(1000)) < 0) {
			mapaVehiculo.put(LocalDate.now(), automovil);
			return true;
		}
		return false;
	}

	public BigDecimal getCosteParking(String matricula) {
		BigDecimal costeParking = BigDecimal.valueOf(20);
		LocalDate hoy = LocalDate.now();
		for (LocalDate fecha : mapaVehiculo.keySet()) {
			if (mapaVehiculo.get(fecha).getMatricula().equalsIgnoreCase(matricula)) {
				if (mapaVehiculo.get(fecha).getTonelaje().compareTo(new BigDecimal(500)) > 0) {
					costeParking = costeParking.add(new BigDecimal(10));
				}
				Period periodo = fecha.until(hoy);
				return costeParking.multiply(new BigDecimal(periodo.getDays() + 1));

			}
		}
		return BigDecimal.ZERO;
	}

	public Boolean salir(String matricula) {
		for (Iterator<LocalDate> iterator = mapaVehiculo.keySet().iterator(); iterator.hasNext();) {
			LocalDate fecha =  iterator.next();
			if (mapaVehiculo.get(fecha).getMatricula().equalsIgnoreCase(matricula)) {
				iterator.remove();
				return true;
			}
			
		}
		return false;
	}

	public BigDecimal getTotalPendienteCobro() {
		BigDecimal totalPendiente = BigDecimal.ZERO;
		for (LocalDate fecha : mapaVehiculo.keySet()) {
			totalPendiente = totalPendiente.add(getCosteParking(mapaVehiculo.get(fecha).getMatricula()));
		}
		return totalPendiente;
	}

}
