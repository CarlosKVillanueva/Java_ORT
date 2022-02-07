package FabricaBotellas.Catedra;

import java.util.ArrayList;

public class Deposito {
	
	private int cantidadMaxima;
	private ArrayList<Botella> botellas;
	
	public Deposito(int cantidadMaxima) {
		botellas = new ArrayList<>();
		setCantidadMaxima(cantidadMaxima);
	}
	
	private void setCantidadMaxima(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}
	
	public boolean puedeAlmacenar(int cantidadBotellas) {
		return (botellas.size() + cantidadBotellas) <= cantidadMaxima;
	}
	
	public void guardar(ArrayList<Botella> nuevas) {
		for (Botella botella : nuevas) {
			botellas.add(botella);
		}
	}
	
	public int enviar() {
		int enviadas = botellas.size();
		if(enviadas > 0) {
			botellas.clear();
		}
		return enviadas;
	}

}
