package EclipsePasion;

public class Metodo {
	private String nombre;
	private int cantInstrucciones;

	public Metodo(String nombre, int cantInstrucciones) {
		this.nombre = nombre;
		this.cantInstrucciones = cantInstrucciones;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantInstrucciones() {
		return cantInstrucciones;
	}

	public boolean mismoMetodo(String nombre) {

		return this.nombre.equals(nombre);
	}

	@Override
	public String toString() {
		return "Metodo nombre: " + nombre + " | cantInstrucciones: " + cantInstrucciones;
	}

}
