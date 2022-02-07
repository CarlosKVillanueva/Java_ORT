package Bingo.Catedra;

import java.util.ArrayList;

public class Bingo {
	private static final int PARTICIPANTES_MINIMOS = 5;
	private static final int PARTICIPANTES_MAXIMOS = 100;
	private ArrayList<Participante> participantes;
	private Bolillero bolillero;

	public void simularRonda(int cantidadParticipantes) {
		System.out.println("*************************************************");
		prepararRonda(cantidadParticipantes);
		ArrayList<Participante> ganadores = jugarRonda();
		informarGanadores(ganadores);
	}

	private void prepararRonda(int cantidadParticipantes) {
		participantes = new ArrayList<>();
		bolillero = new Bolillero();
		if (cantidadParticipantes < PARTICIPANTES_MINIMOS) {
			cantidadParticipantes = PARTICIPANTES_MINIMOS;
		} else if (cantidadParticipantes > PARTICIPANTES_MAXIMOS) {
			cantidadParticipantes = PARTICIPANTES_MAXIMOS;
		}
		generarParticipantes(cantidadParticipantes);
	}

	private void generarParticipantes(int cantidadParticipantes) {
		for (int i = 0; i < cantidadParticipantes; i++) {
			participantes.add(new Participante(i + 1, bolillero.getNumeros()));
		}
	}

	private ArrayList<Participante> jugarRonda() {
		System.out.println("*** Arranca la ronda con " + participantes.size() + " participantes!! ***");
		ArrayList<Participante> ganadores = new ArrayList<>();
		do {
			int numero = bolillero.sacarNumero();

			for (Participante participante : participantes) {
				if (participante.verificarNumero(numero)) {
					ganadores.add(participante);
					System.out.println("---> El participante " + participante.getId() + " canto BINGO con el numero "
							+ numero + " !!!");
				}
			}
		} while (bolillero.tieneNumeros() && ganadores.size() == 0);
		return ganadores;
	}

	private void informarGanadores(ArrayList<Participante> ganadores) {
		System.out.println("*** Se tiraron " + bolillero.getNumerosEmitidos()
				+ " numeros antes de conocer a el o los ganadores!! ***");
		System.out.println("Demos paso a los ganadores y sus cartones:");
		for (Participante ganador : ganadores) {
			System.out.println(ganador);
		}
	}
}