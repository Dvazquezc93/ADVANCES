package ejercicios.EjercicioR10;

import java.util.Scanner;

public class EjercicioR10 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Dime una direccion web:");
		String web = skynnet.nextLine();
		Integer space0 = web.indexOf("//");
		Integer space1 = web.indexOf(".");
		Integer space2 = web.lastIndexOf(".");
		String corte1 = web.substring(0,space0+2);
		String corte2 = web.substring(space0+2,space1);
		String corte3 = web.substring(space1+1,space2);
		String corte4 = web.substring(space2+1);
		System.out.println(corte1);
		System.out.println(corte2);
		System.out.println(corte3);
		System.out.println(corte4);
		skynnet.close();
		
	}

}
