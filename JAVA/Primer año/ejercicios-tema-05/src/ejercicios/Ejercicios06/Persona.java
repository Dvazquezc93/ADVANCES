package ejercicios.Ejercicios06;

import java.math.BigDecimal;

public class Persona {
private String genero;
private BigDecimal altura;

public String getGenero() {
	return genero;
}
public void setGenero(String genero) throws ParametroIncorrectoException  {
	if (genero.toUpperCase().equals("M") || genero.toUpperCase().equals("H")) {
		this.genero = genero;
	}
	else {
		throw new ParametroIncorrectoException("Género incorrecto");
	}
	
}
public BigDecimal getAltura() {
	return altura;
}
public void setAltura(BigDecimal altura) throws ParametroIncorrectoException {
	if (altura.compareTo(BigDecimal.ZERO)>=0 && altura.compareTo(BigDecimal.valueOf(3))<=0) {
		this.altura= altura;
	}
	else {
		throw new ParametroIncorrectoException("Altura incorrecta");
	}
}
@Override
public String toString() {
	return "Persona [genero=" + genero + ", altura=" + altura + "]";
}


}
