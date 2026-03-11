package ExamenBDanielVazquez;

import java.math.BigDecimal;

public class CursoPresencial extends Curso {
private Integer numeroMaxPla;

public CursoPresencial(String nombre, BigDecimal precio ) {
	super(nombre, precio);
	numeroMaxPla = 6;
}

public Integer getNumeroMaxPla() {
	return numeroMaxPla;
}

public void setNumeroMaxPla(Integer numeroMaxPla) {
	this.numeroMaxPla = numeroMaxPla;
}

@Override
public Boolean permiteMatricula() {
	return listaAlumno.size()<numeroMaxPla;
}		

	



}
