package DreamTeam;

import java.util.ArrayList;

public class Liga {
	private String nombre;
	private ArrayList<Equipo> equipos;

	public Liga(String nombre) {
		this.nombre = nombre;
		equipos = new ArrayList<>();

	}

	private Equipo buscarEquipo(String nombre) {
		Equipo equipoABuscar = null;
		int i = 0;

		while (i < equipos.size() && equipoABuscar == null) {
			if (equipos.get(i).mismoNombre(nombre)) {
				equipoABuscar = equipos.get(i);
			} else {
				i++;
			}
		}
		return equipoABuscar;
	}

	public boolean agregarEquipo(String nombre) {

		boolean pudeAgregar = false;

		if (buscarEquipo(nombre) == null) {
			equipos.add(new Equipo(nombre));
			pudeAgregar = true;
		}
		return pudeAgregar;
	}

	public boolean agregarJugAEquipo(String nombre, int numero, String apellido, String nom, Posicion posicion,
			int valoracion) {
		boolean pudeAgregar = false;
		Equipo equipo = buscarEquipo(nombre);

		if (equipo != null) {
			equipo.agregarJugador(numero, apellido, nom, posicion, valoracion);
			pudeAgregar = true;
		}

		return pudeAgregar;

	}

	public ResultadoPartido competir(String nombreEquipoLocal, String equipoRival) {
		ResultadoPartido resultado = ResultadoPartido.PARTIDO_INEXISTENTE;
		Equipo equipoLocal = buscarEquipo(nombreEquipoLocal);
		Equipo equipoVisitante = buscarEquipo(equipoRival);

		if (equipoLocal != null && equipoVisitante != null) {
			if (equipoLocal.valoracion() >= equipoVisitante.valoracion()) {
				resultado = ResultadoPartido.LOCAL;
			} else {
				resultado = ResultadoPartido.VISITANTE;
			}
		}
		return resultado;
	}

	public void mostrarAllStar() {

		int mejorValoracion;
		String datosMejorJugador;
		Jugador mejorJugador = null;

		System.out.println("*** EQUIPO ALL STAR DE LA " + this.nombre + " ***");

		if (!equipos.isEmpty()) {

			for (Posicion posicion : Posicion.values()) {

				mejorValoracion = Integer.MIN_VALUE;
				datosMejorJugador = "Ninguno";

				for (Equipo equipo : equipos) {
					mejorJugador = equipo.mejorJugadorPorPuesto(posicion);

					if (mejorJugador != null && mejorJugador.getValoracion() > mejorValoracion) {
						mejorValoracion = mejorJugador.getValoracion();
						datosMejorJugador = mejorJugador.getNombreCompleto();
					}
				}
				System.out.println(posicion + ":" + datosMejorJugador);
			}

		} else {
			System.out.println("No hay jugadores");
		}

	}

	@Override
	public String toString() {
		return "Liga nombre: " + nombre + " | equipos: " + equipos;
	}

}
