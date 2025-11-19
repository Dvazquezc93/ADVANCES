package ejercicios.Ejerciciosr07;

import java.util.Iterator;
import java.util.Scanner;

public class Ejerciciosr07 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("¿Cuántos alumnos hay en clase?");
		Integer alum1 = skynnet.nextInt();
		String[] arra1 = new String[alum1];
		Integer[] arra2 = new Integer[alum1 * 3];
		Integer[] arra3 = new Integer[alum1];
		Integer media1 = 0, cont1 = 0, mediaT = 0;
		for (Integer i = 0; i < alum1; i++) {
			System.out.println("Cuál es el nombre el alumno " + (i + 1));
			skynnet.nextLine();
			arra1[i]=skynnet.nextLine();
			
			for (Integer e = cont1; e < (3 + cont1); e++) {
				System.out.println("Cuál es la nota de " + arra1[i] + " para el examen " + (i + 1) + " ?");
				arra2[e] = skynnet.nextInt();
			}
			cont1 = cont1 + 3;
		}
		for (Integer i = 0; i < arra3.length; i++) {
			arra3[i] = arra2[media1] + arra2[media1 + 1] + arra2[media1 + 2];
			media1 = media1 + 3;
		}
		for (Integer i = 0; i < arra2.length; i++) {
			mediaT+=arra2[i];
		}
		System.out.println("***Listado de notas****");
		for (Integer i = 0; i < arra3.length; i++) {
			System.out.println("Alumno: "+arra1[i]+" -Nota media:"+arra3[i]/3);
			
		}
		Integer mediaFinal=mediaT/(alum1*3);
		System.out.println("Media de los alumnos: "+mediaFinal);
		skynnet.close();
	}

}
