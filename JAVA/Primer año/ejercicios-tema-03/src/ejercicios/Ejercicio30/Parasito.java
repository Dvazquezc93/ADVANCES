package ejercicios.Ejercicio30;

public class Parasito extends Personaje {
	
	public Parasito() {
		super();
		vida=200;
		daño=2;
		velocidadAtaque=1;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Parasito";
	}



}
