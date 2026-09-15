package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cuadrilla {
	protected String encargado;
	protected List<ObraNueva> listaObra;

	public Cuadrilla() {
		listaObra = new ArrayList<>();
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public List<ObraNueva> getListaObra() {
		return listaObra;
	}

	public void setListaObra(List<ObraNueva> listaObra) {
		this.listaObra = listaObra;
	}

	public List<ObraNueva> getObrasPorObrero(Obrero obrero) {
		List<ObraNueva> obraObreros = new ArrayList<>();
		for (ObraNueva obraNueva : listaObra) {
			if (obraNueva.getListaObreros().contains(obrero)) {
				obraObreros.add(obraNueva);
			}
		}
		return obraObreros;
	}
	
	
}
