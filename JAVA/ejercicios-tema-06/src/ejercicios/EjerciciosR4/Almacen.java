package ejercicios.EjerciciosR4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Almacen {
	private String nombre;
	private Map<String, Cliente> mapaCliente;

	public Almacen(String nombre) {
		this.nombre = nombre;
		mapaCliente = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<String, Cliente> getMapaCliente() {
		return mapaCliente;
	}

	public void setMapaCliente(Map<String, Cliente> mapaCliente) {
		this.mapaCliente = mapaCliente;
	}

	public Integer getCantidadPedidos() {
		Integer cantidadPedidos = 0;
		for (Cliente cliente : mapaCliente.values()) {
			cantidadPedidos= cantidadPedidos +cliente.getArticulosPedidos().size();
		}
		return cantidadPedidos;
	}
	public void borrarClientesPedidos() {
		for (Iterator<String> iterator = mapaCliente.keySet().iterator(); iterator.hasNext();) {
			String type =  iterator.next();
			if (!mapaCliente.get(type).tienePedidosPendientes()) {
				iterator.remove();
			}
		}
	}

}
