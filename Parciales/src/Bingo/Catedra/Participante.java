package Bingo.Catedra;

import java.util.ArrayList;

public class Participante {
	private int id;
	private Carton carton;
	
	public Participante(int id, ArrayList<Integer> numeros) {
		setId(id);
		carton = new Carton(numeros);
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(int numero) {
		this.id = numero;
	}
	
	public boolean verificarNumero(int numero) {
		return carton.buscarNumero(numero);
	}

	@Override
	public String toString() {
		return "Participante " + id + ", " + carton + "]";
	}
}