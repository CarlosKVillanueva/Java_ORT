package Vuelo;

public class Pasajero {
	private String dni;
	private String telefono;

	public Pasajero(String dni, String telefono) {
		this.dni = dni;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Pasajero [dni=" + dni + ", telefono=" + telefono + "]";
	}

}
