package ejercicios.Ejercicio27;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AppFurbo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Equipo> misEquipos = new ArrayList<>();
		List<Jugador> outPlayers = new ArrayList<>();
		do {
			for (Integer i = 0; i < 2; i++) {
				System.out.println("Cual es el nombre del equipo " + (i + 1));
				Equipo team = new Equipo(sc.nextLine());
				misEquipos.add(team);
				List<Jugador> listPlayers = new ArrayList<>();
				for (Integer j = 0; j < 3; j++) {
					Jugador player = new Jugador(null, null);
					listPlayers.add(player);
					System.out.println("Su jugador numero " + (j + 1) + " es:");
					player.setNombre(sc.nextLine());
					System.out.println("EL número de dorsal:");
					player.setDorsal(sc.nextInt());
					sc.nextLine();
					team.setListJugadores(listPlayers);
				}
				team.setCapitan(listPlayers.get(0));
			}
		} while (misEquipos.size() < 2);
		Partido pachanga = new Partido();
		pachanga.setEquipoLocal(misEquipos.get(0));
		pachanga.setEquipoVisitante(misEquipos.get(1));
		Resultado result = new Resultado();
		pachanga.setResultado(result);
		System.out.println(pachanga);
		System.out.println("¿Cual ha sido el resultado real del partido?\n¿Cuantos goles metio "
				+ misEquipos.get(0).getNombre() + "?");
		result.setGolesLocales(sc.nextInt());
		System.out.println("¿Cuantos goles metio " + misEquipos.get(1).getNombre() + "?");
		result.setGolesVisitante(sc.nextInt());
		System.out.println(pachanga);
		System.out.println("Ganador: "+pachanga.getEquipoGanador());
		Jugador extraPlayer = new Jugador("Blas infiltrado", 99);
		misEquipos.get(1).getListJugadores().add(extraPlayer);
		System.out.println(misEquipos.get(1));
		outPlayers = misEquipos.get(0).getListJugadores();
		outPlayers.addLast(outPlayers.get(0));
		outPlayers.remove(0);
		misEquipos.get(0).setCapitan(misEquipos.get(0).getListJugadores().get(0));
		System.out.println(misEquipos.get(0));
		misEquipos.get(0).setCompeticion("Liga Nacional");
		System.out.println(misEquipos.get(0).getCompeticion());
		misEquipos.get(1).setCompeticion("Copa Internacional");
		System.out.println(misEquipos.get(1).getCompeticion());

		sc.close();

	}

}
