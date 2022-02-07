package FabricaBotellas.Catedra;

import java.util.ArrayList;

public class Fabrica {
	
	private Deposito deposito;
	
	public Fabrica(int maxBotellasDeposito) {
		deposito = new Deposito(maxBotellasDeposito);
	}
	
	public int fabricar(int cantidadBotellas) {
		ArrayList<Botella> fabricadas = new ArrayList<>();
		if(deposito.puedeAlmacenar(cantidadBotellas)) {
			fabricadas = Maquina.fabricar(cantidadBotellas);
			if(fabricadas.size() > 0) {
				deposito.guardar(fabricadas);
			}
		}
		return fabricadas.size();
	}
	
	public int enviarBotellas() {
		return deposito.enviar();
	}
}
