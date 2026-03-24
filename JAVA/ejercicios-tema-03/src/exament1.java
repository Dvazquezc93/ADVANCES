import java.util.Iterator;
import java.util.Scanner;

public class exament1 {

	public static void main(String[] args) {
		Scanner skynnet = new Scanner(System.in);
		System.out.println("Dime un número del 2 al 9");
		Integer numeroCasillas = skynnet.nextInt();
		String[] arra1 = new String [numeroCasillas];
		for (Integer i=0;i<arra1.length;i++) {
			type type = (type) iterator.next();
			
		
		for (Integer i=0;i<arra1.length;i++) {
			if (i<numeroCasillas-1) {
				arra1[i]=".";
			}
			else {
				arra1[i]=numeroCasillas.toString();
			}
			
		}
		for (String string : arra1) {
			System.out.println(arra1);
		}
		}
		skynnet.close();

	}

}
