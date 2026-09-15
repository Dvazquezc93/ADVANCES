package ejercicios.Ejercicio19;

import static ejercicios.Ejercicio19.Semaforo.COLOR;

import java.util.Iterator;

public class appSemaforo {

	public static void main(String[] args) {
		Semaforo miSemaforo = new Semaforo();
		miSemaforo.setColor("VIOLETA");
		System.out.println(miSemaforo);
		miSemaforo.setColor(Semaforo.COLOR);
		System.out.println(miSemaforo);
		miSemaforo.setParpadeando(true);
		System.out.println(miSemaforo);
		miSemaforo.setColor(Semaforo.COLOR1);
		System.out.println(miSemaforo);
		miSemaforo.setParpadeando(true);
		System.out.println(miSemaforo);
		for (Integer i = 0; i < 5; i++) {
			miSemaforo.cambiarEstado();
			System.out.println(miSemaforo);

		}
		Semaforo miDosSemaforo = new Semaforo();
		miDosSemaforo.setColor(miSemaforo.getColor());
		miDosSemaforo.setParpadeando(miSemaforo.getParpadeando());
		System.out.println(miDosSemaforo);

	}

}
