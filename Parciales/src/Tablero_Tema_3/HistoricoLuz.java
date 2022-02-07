package Tablero_Tema_3;

public class HistoricoLuz {
	private Accion accion;
	private int numero;
	private boolean prendida;
	private SectorLuz sector;
	private ColorLuz color;

	public HistoricoLuz(Accion accion, Lampara luz) {
		this.accion = accion;
		this.numero = luz.getNumero();
		this.sector = luz.getSector();
		this.color = luz.getColor();
		this.prendida = luz.estaPrendida();
	}

	@Override
	public String toString() {
		return "HistoricoLuz [accion=" + accion + ", numero=" + numero + ", prendida=" + prendida + ", sector="
				+ sector + ", color=" + color + "]";
	}
	
}
