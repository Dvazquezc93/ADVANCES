package ejercicios.EjercicioR22;

import java.util.Iterator;
import java.util.Scanner;

public class EjercicioR22 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		String space1;
		for (Integer num1=1; num1<=10;num1++) {
			System.out.println(num1);
			space1=skynnet.nextLine();
		}
		skynnet.close();
	}

}
