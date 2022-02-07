package Vuelo;

import java.util.ArrayList;

public class Vuelo {
	private String numeroVuelo;
	private int cantidadAsientos;
	private ArrayList<Asiento> asientosReservados;
	private double montoTotal;

	public Vuelo(String numeroVuelo, int cantidadAsientos) {
		this.numeroVuelo = numeroVuelo;
		this.cantidadAsientos = cantidadAsientos;
		this.montoTotal = 0;
		asientosReservados = new ArrayList<>();
	}

	private Asiento buscarAsientoReservado(String fila, int numero) {
		Asiento elementoBuscado = null;
		int i = 0, cantElementos = asientosReservados.size();

		while (i < cantElementos && elementoBuscado == null) {
			if (asientosReservados.get(i).mismoAsiento(fila, numero)) {
				elementoBuscado = asientosReservados.get(i);
			} else {
				i++;
			}
		}
		return elementoBuscado;
	}

	private Asiento buscarPersona(String dni) {
		Asiento elementoBuscado = null;
		int i = 0, cantElementos = asientosReservados.size();

		while (i < cantElementos && elementoBuscado == null) {
			if (asientosReservados.get(i).mismaPersona(dni)) {
				elementoBuscado = asientosReservados.get(i);
			} else {
				i++;
			}
		}
		return elementoBuscado;
	}

	public ResultadoReservaBoletos asignarAsiento(String dni, String telefono, Categoria categoria, String fila,
			int numero) {

		ResultadoReservaBoletos resultado = ResultadoReservaBoletos.ERROR_AVION_COMPLETO;

		if (asientosReservados.size() < cantidadAsientos / 2) {

			if (buscarPersona(dni) == null) {

				if (verDistanciamiento(fila, numero)) {

					Pasajero pasajero = new Pasajero(dni, telefono);
					Asiento asiento = new Asiento(pasajero, categoria, fila, numero);
					asientosReservados.add(asiento);
					montoTotal += asiento.getPrecio();
					resultado = ResultadoReservaBoletos.RESERVA_CONFIRMADA;

				} else {
					resultado = ResultadoReservaBoletos.ERROR_ASIENTO_CONTIGUO_OCUPADO;
				}

			} else {
				resultado = ResultadoReservaBoletos.ERROR_YA_TIENE_PASAJE;
			}
		}

		return resultado;

	}

	private boolean verDistanciamiento(String fila, int numero) {
		boolean pudoReservar = false;

		if (numero == 1 && buscarAsientoReservado(fila, numero + 1) == null) {
			pudoReservar = true;
		} else if (numero == 6 && buscarAsientoReservado(fila, 5) == null) {
			pudoReservar = true;
		} else if ((buscarAsientoReservado(fila, numero - 1) == null)
				&& (buscarAsientoReservado(fila, numero + 1) == null)) {
			pudoReservar = true;
		}
		return pudoReservar;
	}

	// private double obtenerAcumuladoPorClase(Categoria categoria) {
	// double acumClase = 0;

	// for (Asiento asiento : asientosReservados) {
	// if (categoria == Categoria.BUSINESS) {
	// acumClase += asiento.getPrecio();
	// } else if (categoria == Categoria.PRIMERA) {
	// acumClase += asiento.getPrecio();
	// } else {
	// acumClase += asiento.getPrecio();
	// }
	// }
	// return acumClase;
	// }

	private double obtenerAcumuladoPorClase(Categoria categoria) {
		double acumClase = 0;

		for (Asiento asiento : asientosReservados) {
			if (asiento.getCategoria().equals(categoria)) {
				acumClase += asiento.getPrecio();
			}
		}

		return acumClase;
	}

	public void mostrarMontoRecaudadoDeClase(Categoria categoria) {

		if (montoTotal > 0) {
			if (obtenerAcumuladoPorClase(categoria) != 0) {
				System.out.println(
						"El monto acumulado en la clase " + categoria + " es:$ " + obtenerAcumuladoPorClase(categoria));
			} else {
				System.out.println("No hay asientos reservados para la categoria " + categoria);
			}
		} else {
			System.out.println("No hay asientos reservados en ninguna clase");
		}
		System.out.println();

	}

	@Override
	public String toString() {
		return "Vuelo [cantidadAsientos=" + cantidadAsientos + ", montoTotal=" + montoTotal + ", numeroVuelo="
				+ numeroVuelo + "]";
	}

	/*
	 * 
	 * RESERVA_CONFIRMADA RESERVA_CONFIRMADA
	 * ERROR_EL_ASIENTO_DE_AL_LADO_ESTA_OCUPADO
	 * ERROR_EL_ASIENTO_DE_AL_LADO_ESTA_OCUPADO ERROR_YA_ESTA_VENDIDO El monto
	 * acumulado hasta el momento en PRIMERA es: $150000.0 No hay asientos
	 * reservados para clase BUSINESS El monto acumulado hasta el momento en TURISTA
	 * es: $50000.0
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
