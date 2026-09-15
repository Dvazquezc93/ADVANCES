package ejercicios.Ejercicio40;

import java.math.BigDecimal;

public class AppCuentaAhorros {
	public static void main(String[] args) {
		CuentaAhorros c1 = new CuentaAhorros("21005449684984894245");
		System.out.println(c1.Totaldinero());
		Cargo ca1 = new Cargo();
		c1.añadirMovimiento(ca1);
		Cargo ca2 = new Cargo();
		c1.añadirMovimiento(ca2);
		ca1.setImporte(new BigDecimal(33.33));
		ca1.setCif("B1111111");
		ca2.setImporte(new BigDecimal(33.33));
		ca2.setCif("B2222222");
		Ingreso i1 = new Ingreso();
		c1.añadirMovimiento(i1);
		Ingreso i2 = new Ingreso();
		c1.añadirMovimiento(i2);
		i1.setImporte(new BigDecimal(1000.00));
		i1.setDescripcion("Comisiones");
		i2.setImporte(new BigDecimal(1000.00));
		i2.setDescripcion("Cumpleaños");
		Retirada r1 = new Retirada();
		c1.añadirMovimiento(r1);
		r1.setImporte(new BigDecimal(10.00));
		System.out.println(c1.Totaldinero());
		System.out.println(c1.todosMovimienntos());
		System.out.println(c1.todosCargos());
		System.out.println(c1.todosIngresos());
		System.out.println(c1.todosRetiradas());

	}
}
