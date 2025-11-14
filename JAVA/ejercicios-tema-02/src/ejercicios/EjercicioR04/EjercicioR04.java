package ejercicios.EjercicioR04;

import java.util.Scanner;

public class EjercicioR04 {

	public static void main(String[] args) {
		Scanner skynnet= new Scanner (System.in);
		System.out.println("dime el precio del producto: ");
		Integer precio = skynnet.nextInt();
		System.out.println("dime el numero de productos: ");
		Integer unidades = skynnet.nextInt();
		Double descuento4 = precio*1.4;
		Double descuento2 = precio*1.2;
		Double descuento1 = precio*1.1;
		
		if (unidades>100) {
			System.out.println("su precio es: "+descuento4);
		}
		else if (100>unidades||unidades>25) {
			System.out.println("su precio es: "+descuento2);
		}
		else if (24>unidades||unidades>10) {
			System.out.println("su precio es: "+descuento1);
		}
		else if (unidades<10) {
			System.out.println("su precio es: "+precio);
			
		}
			
		
		skynnet.close();
	
}
}
