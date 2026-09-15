package ejercicios.EjercicioPrueba;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pollo extends Animal{

public Pollo (Integer numeroRegistro) {
		this.numeroRegistro =numeroRegistro;
		fechaNacimiento = LocalDate.now();
		peso= BigDecimal.ZERO;
		pesoMinimo= BigDecimal.valueOf(5);
		precioKilo =BigDecimal.valueOf(1.5);
	}
}
