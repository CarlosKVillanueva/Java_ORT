package Bingo.Catedra;

import java.util.ArrayList;

public class Carton {
	private static int CANTIDAD_NUMEROS = 15;
	private ArrayList<Integer> numeros;
	private int restantes;

	public Carton(ArrayList<Integer> numerosBolillero) {
		numeros = new ArrayList<>();
		asignarNumeros(numerosBolillero);
		restantes = CANTIDAD_NUMEROS;
	}

	private void asignarNumeros(ArrayList<Integer> numerosBolillero) {
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			int random = (int) Math.floor(Math.random()*numerosBolillero.size());
			int valor = numerosBolillero.get(random);
			numeros.add(valor);
			numerosBolillero.remove(random);
		}
	}
	
	public boolean buscarNumero(int numero) {
		int i = 0;
		Integer encontrado = null;
		while(i < numeros.size() && encontrado == null) {
			if(numeros.get(i) == numero) {
				encontrado = numero;
			}
			else {
				i++;
			}
		}
		if(encontrado != null) {
			restantes--;
		}
		return restantes == 0;
	}

	@Override
	public String toString() {
		return "numeros del carton :" + numeros + "]";
	}
}