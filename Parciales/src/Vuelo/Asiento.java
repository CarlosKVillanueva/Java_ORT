package Vuelo;


public class Asiento {
	private static final int ASIENTO_MIN = 1;
	private static final int ASIENTO_MAX = 6;
	private static final double PRECIO_TURISTA = 50000;
	private static final double PRECIO_BUSINESS = 100000;
	private static final double PRECIO_PRIMERA = 150000;
	private Pasajero pasajero;
	private Categoria categoria;
	private double precio;
	private String fila;
	private int numero;

	public Asiento(Pasajero pasajero, Categoria categoria, String fila, int numero) {
		this.pasajero = pasajero;
		this.categoria = categoria;
		setPrecio();
		this.fila = fila;
		setNumero(numero);
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setNumero(int numero) {
		if (numero < ASIENTO_MIN) {
			this.numero = ASIENTO_MIN;
		} else if (numero > ASIENTO_MAX) {
			this.numero = ASIENTO_MAX;
		} else {
			this.numero = numero;
		}
	}

	public void setPrecio() {
		if (categoria == Categoria.TURISTA) {
			this.precio = PRECIO_TURISTA;
		} else if (categoria == Categoria.BUSINESS) {
			this.precio = PRECIO_BUSINESS;
		} else {
			this.precio = PRECIO_PRIMERA;
		}
	}

	// public String validarFila(String fila) {
	// String resultado = null;
	// String[] letras = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I",
	// "J", "K", "L", "M", "N", "O", "P",
	// "Q", "R", "S", "T" };
	// ArrayList<String> filas = new ArrayList<>();

	// for (String s : letras) {
	// filas.add(s);
	// }

	// int i = 0;

	// while (i < filas.size() && resultado == null) {
	// if (filas.get(i).equals(fila)) {
	// resultado = filas.get(i);
	// } else {
	// i++;
	// }
	// }
	// return resultado;
	// }

	/* ----------------------- METODOS ---------------------- */

	public boolean mismoAsiento(String fila, int numero) {
		return this.fila.equals(fila) && this.numero == numero;
	}

	public boolean mismaPersona(String dni) {
		return this.pasajero.getDni() == dni;
	}

	@Override
	public String toString() {
		return "Asiento [pasajero=" + pasajero + ", categoria=" + categoria + ", precio=" + precio + ", fila=" + fila
				+ ", numero=" + numero + "]";
	}

}
