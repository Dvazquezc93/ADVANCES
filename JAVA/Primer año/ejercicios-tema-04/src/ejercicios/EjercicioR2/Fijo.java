package ejercicios.EjercicioR2;

public class Fijo extends Telefono{
private String direccion;

public Fijo(Integer numero, String direccion) {
	this.numero=numero;
	this.direccion = direccion;
	enLlamada=false;
}

}
