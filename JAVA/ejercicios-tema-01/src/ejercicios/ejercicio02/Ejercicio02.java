package ejercicios.ejercicio02;

import java.util.Scanner;

public class Ejercicio02 {
public static void main(String[] args) {
	Scanner skynnet = new Scanner(System.in);
	System.out.println("Bienvenido Dani");
	System.out.println("¿De donde eres?");
	String donde = skynnet.nextLine();
	System.out.println("¿como se vive en " + donde + "?");
    skynnet.nextLine();
    System.out.println("Gracias, un saludo.");
    skynnet.close();
}
}
