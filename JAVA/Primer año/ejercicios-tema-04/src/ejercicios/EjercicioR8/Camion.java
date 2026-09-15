package ejercicios.EjercicioR8;

import java.math.BigDecimal;

public class Camion extends Automovil {
protected BigDecimal tonelaje;

public BigDecimal getTonelaje() {
	return tonelaje;
}

public void setTonelaje(BigDecimal tonelaje) {
	this.tonelaje = tonelaje;
}

@Override
public BigDecimal getExtraPeajes() {
	// TODO Auto-generated method stub
	return tonelaje.multiply(new BigDecimal(0.2));
}



}
