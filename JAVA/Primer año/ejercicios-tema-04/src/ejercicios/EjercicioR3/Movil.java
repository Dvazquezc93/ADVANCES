package ejercicios.EjercicioR3;


public class Movil extends Telefono {

private LocalizacionGPS miLocalizacion;

public Movil(Integer numero,LocalizacionGPS miLocalizacion) {
	super();
	this.miLocalizacion = miLocalizacion;
	this.numero=numero;
	enLlamada=false;
}
}
