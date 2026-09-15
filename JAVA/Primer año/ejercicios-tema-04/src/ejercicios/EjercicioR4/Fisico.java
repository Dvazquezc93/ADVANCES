package ejercicios.EjercicioR4;

public class Fisico extends Libro {
private Integer ancho;
private Integer alto;
private Integer peso;
public Fisico() {
}
public Integer getAncho() {
	return ancho;
}
public void setAncho(Integer ancho) {
	this.ancho = ancho;
}
public Integer getAlto() {
	return alto;
}
public void setAlto(Integer alto) {
	this.alto = alto;
}
@Override
public Integer getPeso() {
	return peso;
}
public void setPeso(Integer peso) {
	this.peso = peso;
}

}
