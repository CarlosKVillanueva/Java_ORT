package FabricaBotellas.Catedra;

import java.util.ArrayList;

public class Maquina {

	private final static double ALTURA_VALIDA = 0.5;
	private final static double ALTURA_INVALIDA = 0.4;
	private final static double PROBABILIDAD_CORRECTA = 0.8;
	
	public static ArrayList<Botella> fabricar(int cantidadBotellas){
		ArrayList<Botella> botellasFabricadas = new ArrayList<>();
		for(int i = 0; i < cantidadBotellas; i++) {
			Botella nuevaBotella = fabricarUnaBotella();
			if(nuevaBotella.correcta()) {
				botellasFabricadas.add(nuevaBotella);
			}
			else {
				System.out.println("Desechada :" + nuevaBotella);
			}
		}
		return botellasFabricadas;
	}
	
	private static Botella fabricarUnaBotella() {
		return new Botella(Math.random() <= PROBABILIDAD_CORRECTA ? ALTURA_VALIDA : ALTURA_INVALIDA);  
	}
}
