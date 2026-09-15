package ejercicios.EjercicioR3;

import java.math.BigDecimal;

public class AppTelefono {

	public static void main(String[] args) {
		LocalizacionGPS l1 =new LocalizacionGPS(new BigDecimal(37.370585), new BigDecimal(-6.081728));
		Movil m1 = new Movil(654654654, l1);
		Fijo f1 = new Fijo(954954954, "C. Miguel Servet,número 49, 41930 Bormujos, Sevilla");
		System.out.println(m1.consultarNumero());
		System.out.println(f1.consultarNumero());
		m1.marcar(654654654);
		m1.marcar(610610610);
		m1.colgar();
		m1.colgar();
		

	}

}
