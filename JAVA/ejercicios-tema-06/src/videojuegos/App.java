package videojuegos;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		Videojuego v = new Videojuego();
		v.setId(83);
		v.setNombre("LOL");
		v.setPrecio(BigDecimal.valueOf(23.89));
		
		VideojuegoService service =new VideojuegoService();
		try {
			service.crear(v);
		} catch (VideojuegoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
