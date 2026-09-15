package ejercicios.Ejercicio41;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class AppEvaluacion {

	public static void main(String[] args) {
		Evaluacion e1 = new Evaluacion();
		e1.addNota("77861152B", new BigDecimal(9.0));
		e1.addNota("77861148F", new BigDecimal(4.5));
		e1.addNota("77882252C", new BigDecimal(7.5));
		e1.addNota("28691632Y", new BigDecimal(10.0));
		e1.addNota("28888052H", new BigDecimal(4.0));
		System.out.println(e1);
		e1.addNota("77861152B", new BigDecimal(9.0));
		System.out.println(e1);
		e1.corregirNota("77861152B",new BigDecimal(9.5));
		e1.corregirNota("00000000B",new BigDecimal(9.5));
		System.out.println(e1.obtenerNotaAlumno("28888052H"));
		DecimalFormat formato = new DecimalFormat("#,###.00");
		System.out.println(formato.format(e1.obtenerNotaMedia()));
		System.out.println("La cantidad de aprobados es: "+e1.obtenerCantidadAprobados());
		System.out.println("La lista de suspensos es: "+e1.obtenerSuspensos());	
		e1.borrarAprobados();
		System.out.println(e1);
	}

}
