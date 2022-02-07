package Bingo.Catedra;

import java.util.ArrayList;

public class Bolillero {
	private static final int CANTIDAD_NUMEROS = 90;
	private ArrayList<Integer> numeros;
	
	public Bolillero() {
		numeros = new ArrayList<>();
		generarNumeros();
	}
	
	private void generarNumeros() {
		for(int i = 0; i < CANTIDAD_NUMEROS; i++) {
			numeros.add(i+1);
		}
	}
	
	public boolean tieneNumeros() {
		return numeros.size() > 0;
	}
	
	public ArrayList<Integer> getNumeros(){
		return new ArrayList<>(numeros);
	}
	
	public int sacarNumero() {
		int numeroObtenido = -1;
		if(numeros.size() > 0) {
			int random = (int) Math.floor(Math.random()*numeros.size());
			numeroObtenido = numeros.get(random);
			numeros.remove(random);
		}
		return numeroObtenido;
	}
	
	public int getNumerosEmitidos() {
		return CANTIDAD_NUMEROS - numeros.size();
	}
}