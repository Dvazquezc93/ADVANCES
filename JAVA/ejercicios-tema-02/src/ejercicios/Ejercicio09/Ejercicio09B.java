package ejercicios.Ejercicio09;

import java.util.Scanner;

public class Ejercicio09B {

	public static void main(String[] args) {
		Scanner skynnet= new Scanner(System.in);
		System.out.println("Nombre completo: ");
		String na = skynnet.nextLine();
		Integer space1= na.indexOf(" ");
		Integer space2 =na.indexOf(" ", space1+1);
		
		String nombre = na.substring(0,space1);
		
		String apellido1 = na.substring(space1+1,space2);
		String apellido2 = na.substring(space2+1);
		
		System.out.println("su nombre es: "+nombre+ ",su apellido es: "+apellido1+" ,su segundo apellido es:"+apellido2);
		skynnet.close();

	}

}
