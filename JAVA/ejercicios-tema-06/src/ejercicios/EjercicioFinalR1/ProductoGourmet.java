package ejercicios.EjercicioFinalR1;

import java.math.BigDecimal;

public class ProductoGourmet {
private Integer id;
private String  nombre;
private String  tipo;
private BigDecimal precio;
private Boolean disponible;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public BigDecimal getPrecio() {
	return precio;
}
public void setPrecio(BigDecimal precio) {
	this.precio = precio;
}
public Boolean getDisponible() {
	return disponible;
}
public void setDisponible(Boolean disponible) {
	this.disponible = disponible;
}

public Boolean validarPrecio() {
	return getPrecio().compareTo(BigDecimal.ZERO)>0;
}

@Override
public String toString() {
	return "ProductoGourmet [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + "]";
}


}
