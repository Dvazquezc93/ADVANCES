package ejercicios.Ejercicio09;

import java.util.Scanner;

public class Ejercicio09 {
	public static void main(String[] args) {
		Scanner skynnet= new Scanner(System.in);
		System.out.println("Nombre completo: ");
		String na = skynnet.nextLine();
		String nombre= na.substring(0,6);
		String apellido1= na.substring(7,14);
		String apellido2= na.substring(15,25);
		System.out.println("su nombre es: "+nombre+ " ,su apellido es: "+apellido1+" ,su segundo apellido es :"+apellido2);
		skynnet.close();
	}

	
	

}
