package ejercicios.EjercicioR06;

import java.util.Iterator;

public class EjercicioR06 {

	public static void main(String[] args) {
		Integer suma=0;
		for (Integer num=1;num<=10; num++) {
			System.out.print(num*3);
			suma+=num*3;
			if (num<10) {
				System.out.print("+");
			}
		}
			
		System.out.println("="+suma);
	}

}
