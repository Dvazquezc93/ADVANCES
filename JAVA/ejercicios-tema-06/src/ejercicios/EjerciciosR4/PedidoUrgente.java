package ejercicios.EjerciciosR4;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoUrgente extends Pedido {

	public PedidoUrgente(Integer numero) {
		super(numero);
	}

	@Override
	public LocalDate getFechaEntregaPrevista() {
		return getFechaPedido().plusDays(1);
	}
	@Override
	public BigDecimal getImporteTotal() throws EstadoIncorrectoException {
		if (getEntregado()) {
			throw new EstadoIncorrectoException("El pedido ya ha sido entregado");
		} else if (getFechaEntregaPrevista().compareTo(getFechaPedido()) < 0) {
			return getPrecio();
		}
		return getPrecio().multiply(BigDecimal.valueOf(1.20));
	}
}
