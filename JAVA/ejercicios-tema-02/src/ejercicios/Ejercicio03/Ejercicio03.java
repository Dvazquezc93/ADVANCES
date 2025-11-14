package ejercicios.Ejercicio03;

import java.util.Scanner;

public class Ejercicio03 {
public static void main(String[] args) {
	Scanner skynnet = new Scanner(System.in);
	System.out.println("digame precio sin iva: ");
	Double sin = skynnet.nextDouble();
	System.out.println("tipo de iva:(1)normal, (2)reducido, (3)superreducido, (4)excento ");
	Integer tipo = skynnet.nextInt();
	
	if (tipo==1) {
		System.out.println(sin*0.21);
	}
	else if (tipo==2) {
		System.out.println(sin*0.10);
	}
	else if (tipo==3) {
		System.out.println(sin*0.04);
	}
	else if (tipo==4) {
		System.out.println(sin);
	}
	skynnet.close();
	
	
	
}
}
