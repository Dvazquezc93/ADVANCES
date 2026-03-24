package ejercicios.Ejercicio36;

import java.util.HashSet;
import java.util.Set;

public class AppPais {
	public static void main(String[] args) {
		Set<Pais> bolsa = new HashSet<>();
		System.out.println(bolsa);
		bolsa.add(new Pais("ES", "España"));
		bolsa.add(new Pais("CK", "Isla Cook"));
		bolsa.add(new Pais("CK", "Isla Caimán"));
		System.out.println(bolsa);
		bolsa.add(new Pais("es", "España"));
		System.out.println(bolsa);
		bolsa.clear();
		System.out.println(bolsa);
	}

}
