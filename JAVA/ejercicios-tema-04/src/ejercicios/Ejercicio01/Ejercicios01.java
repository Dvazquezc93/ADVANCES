package ejercicios.Ejercicio01;

import java.util.Scanner;

import ejercicios.Ejercicio02.ConsoleInOut;

public class Ejercicios01 {

	public static void main(String[] args) {
		ConsoleInOut console = new ConsoleInOut();
		Calculadora calculadora = new Calculadora();
		Integer selectCalculator = 0;
		Double valorUsuario = 0.0;
		Boolean finishCal = true;
		do {
			Double valorCalculadora = calculadora.getValor();
			selectCalculator = console.readInteger(
					"****Calculadora****\n" + valorCalculadora
							+ "\n1.Sumar\n2.Restar\n3.Multiplicar\n4.Dividir\n5.Calculadora a cero\n6.Terminar");
			if (selectCalculator == 1) {
				valorUsuario = console.readDouble("¿cuanto quiere sumar?");
				calculadora.sumar(valorUsuario);
			} else if (selectCalculator == 2) {
				valorUsuario = console.readDouble("¿cuanto quiere restar?");
				calculadora.restar(valorUsuario);
			} else if (selectCalculator == 3) {
				valorUsuario = console.readDouble("¿cuanto quiere multiplicar?");
				calculadora.multiplicar(valorUsuario);
			} else if (selectCalculator == 4) {
				valorUsuario = console.readDouble("¿cuanto quiere dividir?");
				calculadora.dividir(valorUsuario);
			} else if (selectCalculator == 5) {
				calculadora.cero();
			} else if (selectCalculator == 6) {
				finishCal = console.isContinue();
			} else if (selectCalculator > 6 && selectCalculator < 1) {
				System.out.println("Error, vuelve a intentarlo.");
			}
		} while (selectCalculator != 6);
		System.out.println("****FIN CALCULADORA****");

		console.close();

	}

}
