package ejercicios.Ejercicios17;

public class Ejercicios17 {

	public static void main(String[] args) {
		Double[] arra1 = {1.5, 2.3, 3.7, 4.0};
		Double suma1=0.0;
		for (Double dec1 : arra1) {
			System.out.println("Sus numeros son "+dec1);
		}
		for (Double dec1 : arra1) {
			suma1=suma1+dec1;
			
		}
		System.out.println("Su Suma total es "+suma1);
}
}
