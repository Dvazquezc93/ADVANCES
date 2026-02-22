package ejercicios.Ejercicio44;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diccionario {
	protected Map<String, List<String>> mapaDic;

	public Diccionario() {

		this.mapaDic = new HashMap<>();
	}

	public Map<String, List<String>> getMapaDic() {
		return mapaDic;
	}

	public void setMapaDic(Map<String, List<String>> mapaDic) {
		this.mapaDic = mapaDic;
	}

	public void cargarDiccionario(List<String> separaPalabras) {
		for (Integer i = 0; i < separaPalabras.size(); i++) {
			if (mapaDic.containsKey(separaPalabras.get(i).substring(0, 1).toUpperCase())) {
				mapaDic.get(separaPalabras.get(i).substring(0, 1).toUpperCase()).add(separaPalabras.get(i));
			} else {
				List<String> lista2 = new ArrayList<>();
				lista2.add(separaPalabras.get(i));
				mapaDic.put(separaPalabras.get(i).substring(0, 1).toUpperCase(), lista2);
			}
		}
	}

	public void borrarDiccionario() {
		mapaDic.clear();
	}

	public String imprimirPalabras(String letra) {
		String palabrasCompletas = "";
		letra = letra.toUpperCase();
		palabrasCompletas = "Hay " + mapaDic.get(letra).size() + " palabras que empiezan por " + letra + ":\n";
		for (int i = 0; i < mapaDic.get(letra).size(); i++) {
			palabrasCompletas += "\t>" + mapaDic.get(letra).get(i)+"\n";
		}
		return palabrasCompletas;
	}

}
