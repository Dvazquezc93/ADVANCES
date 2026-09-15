package ejercicios.Ejercicio39;

import java.math.BigDecimal;
import ejercicios.Ejercicio39.Hucha;

public class AppHucha {

	public static void main(String[] args) {
		Hucha h1 = new Hucha();
		System.out.println(h1);
		h1.meterDinero(BigDecimal.valueOf(100));
		System.out.println(h1);
		h1.meterDinero(BigDecimal.valueOf(50.501));
		System.out.println(h1);
		h1.sacarDinero(BigDecimal.valueOf(20.50));
		System.out.println(h1);
		h1.sacarDinero(BigDecimal.valueOf(200));
		System.out.println(h1);
		h1.meterDinero(BigDecimal.valueOf(130));
		System.out.println(h1);
		h1.meterDinero(h1.contarDinero());
		System.out.println(h1);
		h1.meterDinero(h1.romperHucha());
		

	}

}
