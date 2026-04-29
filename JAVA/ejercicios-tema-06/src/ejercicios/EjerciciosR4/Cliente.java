package ejercicios.EjerciciosR4;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente {
	private String dni;
	private List<Pedido> listaPedido;

	public Cliente() {

		listaPedido = new ArrayList<>();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public Boolean tienePedidosPendientes() {
		for (Pedido pedido : listaPedido) {
			if (!pedido.getEntregado()) {
				return false;
			}
		}
		return true;
	}

	public BigDecimal getImportePendiente() throws EstadoIncorrectoException {
		BigDecimal importePendiente = BigDecimal.ZERO;
		for (Pedido pedido : listaPedido) {
			if (!pedido.getEntregado()) {
				importePendiente = importePendiente.add(pedido.getImporteTotal());
			}
		}
		return importePendiente;
	}

	public Map<Integer, Integer> getArticulosPedidos() {
		Map<Integer, Integer> mapaPendiente = new HashMap<>();
		for (Pedido pedido : listaPedido) {
			mapaPendiente.put(pedido.getNumero(), pedido.getCantidadArticulos());
		}
		return mapaPendiente;
	}

	public Pedido getPedidoCritico() throws NoExisteException {
		Pedido pedidoCritico = null;
		Period periodoCritico = null;
		for (Pedido pedido : listaPedido) {
	
			Period periodo = pedido.getFechaEntregaPrevista().until(LocalDate.now());
			if ((!pedido.getEntregado()) && pedidoCritico == null && periodo.getDays() < 30) {
				pedidoCritico = pedido;
				periodoCritico = pedidoCritico.getFechaEntregaPrevista().until(LocalDate.now());
			} else if (!(pedido.getEntregado()) && periodoCritico.getDays() < periodo.getDays()
					&& periodo.getDays() < 30) {
				pedidoCritico = pedido;
			} else {
				throw new NoExisteException("No existe pedido");
			}
		}
		return pedidoCritico;

	}

}
