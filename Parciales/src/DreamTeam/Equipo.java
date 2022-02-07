package DreamTeam;

import java.util.ArrayList;

/**
 * @author Carlos K. Villanueva
 *
 * 6 nov 2021
 */

public class Equipo {
	private String nombre;
	private ArrayList<Jugador> jugadores;
	private final static int JUGADORES = 18;

	public Equipo(String nombre) {
		this.nombre = nombre;
		jugadores = new ArrayList<>();
	}

	public boolean mismoNombre(String nombre) {
		return this.nombre.equals(nombre);
	}

	private Jugador buscarJugador(int numero) {
		Jugador jugadorABuscar = null;
		int i = 0;

		while (i < jugadores.size() && jugadorABuscar == null) {
			if (jugadores.get(i).mismoNumero(numero)) {
				jugadorABuscar = jugadores.get(i);
			} else {
				i++;
			}
		}
		return jugadorABuscar;
	}

	public boolean agregarJugador(int numero, String apellido, String nombre, Posicion posicion, int valoracion) {

		boolean pudeAgregar = false;

		if (jugadores.size() <= JUGADORES) {
			if (buscarJugador(numero) == null) {
				jugadores.add(new Jugador(numero, apellido, nombre, posicion, valoracion));
				pudeAgregar = true;
			}

		}
		return pudeAgregar;
	}

	public double valoracion() {
		double acum = 0;
		if (jugadores.size() > 0) {
			for (Jugador jugador : jugadores) {
				acum += jugador.getValoracion();
			}
		}
		return acum / jugadores.size();
	}

	public Jugador mejorJugadorPorPuesto(Posicion posicion) {
		int mejorValoracion = Integer.MIN_VALUE;
		Jugador mejorJugador = null;
		
		if (jugadores.size() > 0) {
			for (Jugador jugador : jugadores) {
				if(jugador.getPosicion() == posicion && jugador.getValoracion() > mejorValoracion) {
					mejorValoracion = jugador.getValoracion();
					mejorJugador = jugador;
				}
			}
		}
		return mejorJugador;
	}


	@Override
	public String toString() {
		return "Equipo nombre: " + nombre + " | jugadores: " + jugadores;
	}

}
