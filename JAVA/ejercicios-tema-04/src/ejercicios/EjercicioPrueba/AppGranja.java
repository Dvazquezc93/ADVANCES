package ejercicios.EjercicioPrueba;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppGranja {

	public static void main(String[] args) {
		Granja g1 = new Granja("Sevilla");
		System.out.println(">>Apartado 1:\n\t"+g1);
		Cerdo c1 =new Cerdo(1);
		c1.setRaza("Ibérico bellota");
		g1.addAnimal(c1);
		Cerdo c2 =new Cerdo(2);
		c2.setRaza("Ibérico cebo");
		g1.addAnimal(c2);
		Pollo p1 = new Pollo(3);
		Pollo p2 = new Pollo(4);
		Pollo p3 = new Pollo(5);
		g1.addAnimal(p1);
		g1.addAnimal(p2);
		g1.addAnimal(p3);
		System.out.println(">>Apartado 2:\n\t"+g1);
		c1.setPeso(new BigDecimal(120.40));
		c1.setFechaNacimiento(LocalDate.of(2024,01, 15));
		c2.setPeso(new BigDecimal(84));
		LocalDate mesesp1 = p1.getFechaNacimiento().plusMonths(3);
		p1.setFechaNacimiento(mesesp1);
		LocalDate  mesesp2 = p2.getFechaNacimiento().plusMonths(3);
		p2.setFechaNacimiento(mesesp2);
		LocalDate mesesp3 = c1.getFechaNacimiento().plusMonths(3);
		p3.setFechaNacimiento(mesesp3);
		p1.setPeso(new BigDecimal(3));
		p2.setPeso(new BigDecimal(3));
		p3.setPeso(new BigDecimal(13));
		System.out.println(">>Apartado 3:\n\t"+g1);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaCadena = p3.getFechaNacimiento().format(formato);
		System.out.println(">>Apartado 4:\n\t"+fechaCadena+"\n\t"+p3.getEdad()+" meses");
		DecimalFormat formato2 = new DecimalFormat("#,###.00€");
		System.out.println(">>Apartado 5:\n\t"+formato2.format(g1.calcularPrecioVenta()));
		g1.venderAnimales();
		System.out.println(">>Apartado 6:\n\t"+g1);
	}

}
