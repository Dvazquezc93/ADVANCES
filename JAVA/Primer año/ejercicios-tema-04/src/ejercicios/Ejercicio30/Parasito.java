package ejercicios.Ejercicio30;

public class Parasito extends Personaje {

	public Parasito(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
		vida = 200;
		daño = 2;
		velocidadAtaque = 1;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Parasito";
	}

}
