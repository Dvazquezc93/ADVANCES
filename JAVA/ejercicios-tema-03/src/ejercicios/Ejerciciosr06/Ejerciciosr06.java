package ejercicios.Ejerciciosr06;

import java.util.Scanner;

public class Ejerciciosr06 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Pon tu html:");
		String html1 = skynnet.nextLine();
		String[]arra1= html1.split("");
		String text1 = "";
		for (Integer i=0;i<arra1.length-1;i++) {
			if (arra1[i].equals(">")&&!(arra1[i+1].equals("<"))) {
				for (Integer e=i;!(arra1[e].equals("<"));e++) {
					if (arra1[e].equals(">")) {
						arra1[e]= "\n";
					}
						;
						text1=text1+arra1[e];
					}
				}
			}
		System.out.println(text1);
		skynnet.close();

	}

}
