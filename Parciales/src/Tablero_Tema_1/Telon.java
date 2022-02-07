package Tablero_Tema_1;

public class Telon {
	private boolean abierto;
	
	public Telon() {
		abierto = false;
	}
	
	public boolean subir() {
		boolean ok = false;
		if (!abierto) {
			abierto = !abierto;
			ok = true;
		}
		return ok;
	}
	
	public boolean bajar() {
		boolean ok = false;
		if (abierto) {
			abierto = !abierto;
			ok = true;
		}
		return ok;
	}

	public boolean estaAbierto() {
		return abierto;
	}
}
