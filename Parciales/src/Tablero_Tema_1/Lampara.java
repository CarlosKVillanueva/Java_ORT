package Tablero_Tema_1;

public class Lampara {
	private int numero;
	private boolean prendida;
	private SectorLuz sector;
	private ColorLuz color;

	public Lampara(int numero, SectorLuz posicion, ColorLuz color) {
		setNumero(numero);
		setPosicion(posicion);
		setColor(color);
		prendida = false;
	}
	
	public void apagar() {
		if (prendida) invertirEstado();
	}

	public boolean estaPrendida() {
		return prendida;
	}

	public ColorLuz getColor() {
		return color;
	}

	public int getNumero() {
		return numero;
	}
	
	public SectorLuz getSector() {
		return sector;
	}

	public void prender() {
		if (!prendida) invertirEstado();
	}

	private boolean invertirEstado() {
		return prendida = !prendida;
	}

	public void setColor(ColorLuz color) {
		this.color = color;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}

	private void setPosicion(SectorLuz posicion) {
		this.sector = posicion;
	}
}