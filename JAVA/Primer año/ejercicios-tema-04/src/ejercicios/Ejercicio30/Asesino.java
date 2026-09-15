package ejercicios.Ejercicio30;

public class Asesino extends Personaje{

	public Asesino(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
		vida=100;
		daño=10;
		velocidadAtaque=5;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Asesino";
	}
	
	
}
