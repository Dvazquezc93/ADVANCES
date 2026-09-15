package ejercicios.Ejercicio46;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Naipe {
private Integer numero;
private String palo;

public Integer valorMenor() {
	if (numero>9) {
		return 10;
	}
	return numero;
}
public Integer valorMayor() {
	if (numero>9) {
		return 10;
	}
	else if (numero==1) {
		return 11;
	}
	return numero;
}
public String formatoNumero() {
	Map<Integer, String> baraja = new HashMap<>();
	baraja.put(1,"A");
	baraja.put(10,"J");
	baraja.put(11,"Q");
	baraja.put(12,"K");
	for (Integer i = 2; i < 10; i++) {
		baraja.put(i,i.toString());
	}
	return baraja.get(numero);
}
@Override
public String toString() {
	return "Naipe [numero=" + formatoNumero() + ", palo=" + palo + "]";
}

}
