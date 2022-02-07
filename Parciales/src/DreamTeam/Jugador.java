package DreamTeam;

public class Jugador {

	private static final int VALORACION_MINIMA = 50;
	private static final int VALORACION_MAXIMA = 100;
	private int numero;
	private String apellido;
	private String nombre;
	private Posicion posicion;
	private int valoracion;

	public Jugador(int numero, String apellido, String nombre, Posicion posicion, int valoracion) {
		this.numero = numero;
		this.apellido = apellido;
		this.nombre = nombre;
		this.posicion = posicion;
		setValoracion(valoracion);
	}

	public int getValoracion() {
		return valoracion;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public String getNombreCompleto() {

		return this.nombre + " " + this.apellido;
	}

	@Override
	public String toString() {
		return " " +apellido + ", " + nombre;
	}

	public boolean mismoNumero(int numero) {

		return this.numero == numero;
	}

	private void setValoracion(int valoracion) {
		if (valoracion > VALORACION_MAXIMA) {
			this.valoracion = VALORACION_MAXIMA;
		} else if (valoracion < VALORACION_MINIMA) {
			this.valoracion = VALORACION_MINIMA;

		} else {
			this.valoracion = valoracion;
		}
	}

}
