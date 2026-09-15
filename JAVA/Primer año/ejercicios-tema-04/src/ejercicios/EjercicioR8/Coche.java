package ejercicios.EjercicioR8;

import java.math.BigDecimal;

public class Coche extends Automovil{
private Integer ocupante;

public Integer getOcupante() {
	return ocupante;
}

public void setOcupante(Integer ocupante) {
	this.ocupante = ocupante;
}

@Override
public BigDecimal getExtraPeajes() {
	BigDecimal extraPeaje = BigDecimal.valueOf(ocupante);
	 return extraPeaje.multiply(new BigDecimal(5));
}

@Override
public BigDecimal getTonelaje() {
	// TODO Auto-generated method stub
	return BigDecimal.ZERO;
}



}
