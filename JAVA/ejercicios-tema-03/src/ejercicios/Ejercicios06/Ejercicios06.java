package ejercicios.Ejercicios06;


import java.util.Scanner;

public class Ejercicios06 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		String[] arra1 = new String[3];
		String fin1="";
		for (Integer i=0;i<3;i++) {
			System.out.println("Dime una palabra:");
			arra1[i] = skynnet.nextLine();
			
		}
		for (Integer i=0;i<3;i++) {
			fin1=fin1+arra1[i];
			
		}
		System.out.println(fin1);
		skynnet.close();
	}

}
