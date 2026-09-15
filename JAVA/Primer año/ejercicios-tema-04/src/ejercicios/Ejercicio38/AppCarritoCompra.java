package ejercicios.Ejercicio38;

import java.math.BigDecimal;

public class AppCarritoCompra {
public static void main(String[] args) {
	Cliente miCliente = new Cliente("12345678X","Blas de los Montes");
	CarritoCompra miCarrito = new CarritoCompra(miCliente);
	System.out.println(miCarrito);
	Ropa r1 =new Ropa("Poncho","XL");
	r1.setPrecio(20.00);
	r1.setColor("Azul");
	miCarrito.addArticulo(r1);
	miCarrito.addArticulo(r1);
	System.out.println(miCarrito);
	Libro l1 =new Libro();
	l1.setAutor("Nietzsche");
	l1.setPrecio(15.00);
	l1.setDescripcion("Así habló Zaratustra");
	miCarrito.addArticulo(l1);
	System.out.println(miCarrito);
	miCarrito.borrarArticulo(0);
	System.out.println(miCarrito);
	System.out.println("Su precio medio de articulos es: "+miCarrito.getPrecioMedio());
	miCarrito.vaciarCesta();
	System.out.println(miCarrito);
	System.out.println("Su precio medio de articulos es: "+miCarrito.getPrecioMedio());
	
}
}
