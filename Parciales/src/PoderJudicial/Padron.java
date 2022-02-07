package PoderJudicial;

import java.util.ArrayList;

public class Padron {
	private ArrayList<Escuela> escuelas;

	public Padron() {
		escuelas = new ArrayList<>();
	}

	private Escuela buscarEscuela(String nombre) {
		Escuela elementoBuscado = null;
		int i = 0, cantElementos = escuelas.size();

		while (i < cantElementos && elementoBuscado == null) {
			if (escuelas.get(i).mismaEscuela(nombre)) {
				elementoBuscado = escuelas.get(i);
			} else {
				i++;
			}
		}
		return elementoBuscado;
	}

	public boolean agregarEscuela(String nombre, int cantMesas, Domicilio domicilio) {
		boolean agregada = false;

		if (!nombre.isEmpty()) {
			Escuela escuela = buscarEscuela(nombre);

			if (escuela == null) {
				escuelas.add(new Escuela(nombre, cantMesas, domicilio));
				agregada = true;
			}
		}

		return agregada;
	}

	public boolean agregarMesaEscuela(String nombre, int numeroMesa) {
		boolean agregada = false;

		if (!nombre.isEmpty() && numeroMesa > 0) {
			Escuela escuela = buscarEscuela(nombre);
			if (escuela != null) {
				agregada = escuela.agregarMesa(numeroMesa);
			}
		}

		return agregada;
	}

	public boolean agregarVotanteMesa(String nombre, int numeroMesa, String dni, boolean presidente, String nombreVot,
			String apellido, String fechaNac, Genero tipoGenero) {

		boolean agregado = false;

		Escuela escuela = buscarEscuela(nombre);

		if (escuela != null) {
			agregado = escuela.agregarVotanteMesa(numeroMesa, dni, presidente, nombreVot, apellido, fechaNac,
					tipoGenero);
		}

		return agregado;
	}

}
