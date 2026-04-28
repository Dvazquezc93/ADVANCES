package ejercicios.EjercicioR3;

import java.math.BigDecimal;

public class LibroAntiguo extends Libro {
private Integer antiguedad;

@Override
public BigDecimal getPrecio() {
	return this.getPrecio().divide(BigDecimal.TWO);
}
public Integer getAntiguedad() {
	return antiguedad;
}

public void setAntiguedad(Integer antiguedad) {
	this.antiguedad = antiguedad;
}

}
