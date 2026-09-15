package ejercicios.Ejercicio34;

import ejercicios.Ejercicio34.CarritoCompra2;
import ejercicios.Ejercicio34.Cliente;
import ejercicios.Ejercicio34.Libro;
import ejercicios.Ejercicio34.Ropa;

public class AppCarritoCompra2 {
public static void main(String[] args) {
	Cliente miCliente = new Cliente("Blas de los Montes","12345678X");
	CarritoCompra2 miCarrito = new CarritoCompra2(miCliente);
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
	miCarrito.borrarArticulo(r1);
	System.out.println(miCarrito);
	System.out.println("Su precio medio de articulos es: "+miCarrito.getPrecioMedio());
	miCarrito.vaciarCesta();
	System.out.println(miCarrito);
	System.out.println("Su precio medio de articulos es: "+miCarrito.getPrecioMedio());
	
}
}