package ejercicios.Ejercicio37;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio37 {
	public static void main(String[] args) {
		List<BigDecimal> misNumeros = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		for (Integer i = 0; i < 5; i++) {
			Boolean mayor = false;
			do {
				System.out.print("Numero " + (i + 1) + ":");
				BigDecimal numeroBd = sc.nextBigDecimal();
				if (misNumeros.size()==0) {
					mayor = true;
					misNumeros.add(numeroBd);
				}
				else if (misNumeros.get(i-1).compareTo(numeroBd) < 0 ) {
					mayor = true;
					misNumeros.add(numeroBd);

				}
				else {
					System.out.println("El número no es mayor que el anterior");
				}

			} while (!mayor);
		}
		BigDecimal totalSuma = BigDecimal.ZERO;
		for (Integer i = 0; i < misNumeros.size(); i++) {
			totalSuma= totalSuma.add(misNumeros.get(i));
		}
		totalSuma= totalSuma.setScale(1,RoundingMode.HALF_DOWN);
		System.out.println("Su suma total es: "+totalSuma);
		BigDecimal division = misNumeros.get(0).divide(misNumeros.get(1),3,RoundingMode.HALF_UP);
		System.out.println("Su division es:"+division);
	
	}
}
