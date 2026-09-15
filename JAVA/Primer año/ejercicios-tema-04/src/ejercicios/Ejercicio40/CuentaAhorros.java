package ejercicios.Ejercicio40;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentaAhorros {
	private String cuentaBancaria;
	private List<Movimiento> listaMovimiento;
	private BigDecimal dinero;

	public CuentaAhorros(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
		listaMovimiento = new ArrayList<>();
	}

	public void añadirMovimiento(Movimiento movimiento) {
		listaMovimiento.add(movimiento);
	}

	public BigDecimal Totaldinero() {
		BigDecimal total = BigDecimal.ZERO;
		if (listaMovimiento.size() != 0) {
			for (Movimiento movimientos : listaMovimiento) {
				total = total.add(movimientos.getImporte());
			}

		}
		return total;

	}

	public String todosMovimienntos() {
		String lista = "";
		if (listaMovimiento.size() != 0) {
			for (Movimiento movimiento : listaMovimiento) {
				lista += movimiento;
			}
		}

		return lista;
	}

	public String todosRetiradas() {
		String lista = "";
		if (listaMovimiento.size() != 0) {
			for (Movimiento movimiento : listaMovimiento) {
				if (movimiento.tipoMovimiento().contains("R")) {
					lista += movimiento;
				}

			}
		}

		return lista;
	}

	public String todosIngresos() {
		String lista = "";
		if (listaMovimiento.size() != 0) {
			for (Movimiento movimiento : listaMovimiento) {
				if (movimiento.tipoMovimiento().contains("I")) {
					lista += movimiento;
				}

			}
		}

		return lista;
	}

	public String todosCargos() {
		String lista = "";
		if (listaMovimiento.size() != 0) {
			for (Movimiento movimiento : listaMovimiento) {
				if (movimiento.tipoMovimiento().contains("C")) {
					lista += movimiento;
				}

			}
		}

		return lista;
	}
	
}
