package ejercicios.EjercicioPrueba;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cerdo extends Animal{
private String raza;

public Cerdo(Integer numeroRegistro) {
	this.numeroRegistro =numeroRegistro;
	fechaNacimiento = LocalDate.now();
	peso= BigDecimal.ZERO;
	pesoMinimo= BigDecimal.valueOf(100);
	precioKilo =BigDecimal.valueOf(4.5);
}

public String getRaza() {
	return raza;
}

public void setRaza(String raza) {
	this.raza = raza;
}

}
