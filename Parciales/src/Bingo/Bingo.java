package Bingo;

import java.util.ArrayList;

public class Bingo {

    private int PARTICIPANTES_MINIMOS = 2, PARTICIPANTES_MAXIMOS = 100;
    private String nombre;
    private Bolillero bolillero;
    private int rondaActual = 0;
    private static int numeroGanador = 0;
    private ArrayList<Participante> participantes;
    private ArrayList<Participante> ganadores;

    public Bingo(String nombre) {
        this.nombre = nombre;
    }

    public void simularRonda(int cantidadParticipantes) {
        int jugadores = jugadoresValidos(cantidadParticipantes);
        this.participantes = new ArrayList<>();
        this.bolillero = new Bolillero();
        bolillero.agregarNumeros();
        agregarParticipantes(jugadores);
        controlarCarton();
        mostrarResultados();
    }

    private ArrayList<Participante> controlarCarton() {
        ganadores = new ArrayList<>();
        while (ganadores.size() == 0) {
            int numeroRonda = bolillero.sacarNumero();

            for (Participante participante : participantes) {
                if (participante.chequearNumero(numeroRonda) == 0) {
                    ganadores.add(participante);
                }
            }
            rondaActual++;
            numeroGanador = numeroRonda;
        }
        return ganadores;
    }

    private void agregarParticipantes(int jugadores) {
        int contadorID = 1;

        for (int i = 0; i < jugadores; i++) {
            participantes.add(new Participante(contadorID++, bolillero.getNumeros()));
        }
    }

    private int jugadoresValidos(int cantidadParticipantes) {
        int jugadoresRonda = 0;

        if (cantidadParticipantes < PARTICIPANTES_MINIMOS) {
            jugadoresRonda = PARTICIPANTES_MINIMOS;
        } else if (cantidadParticipantes > PARTICIPANTES_MAXIMOS) {
            jugadoresRonda = PARTICIPANTES_MAXIMOS;
        } else {
            jugadoresRonda = cantidadParticipantes;
        }

        return jugadoresRonda;
    }

    public void mostrarResultados() {
        System.out.println("*************************************************");
        System.out.println("*** Arranca la ronda con " + participantes.size() + " participantes");
        for (Participante participante : ganadores) {
            System.out.println(
                    "--> El participante " + participante.getId() + " cantó BINGO con el numero " + numeroGanador);
        }
        System.out.println("Se tiraron " + rondaActual + "numeros antes de conocer a el/los ganadores");
        System.out.println("Demos paso a los ganadores y sus cartones:");
        for (Participante participante : ganadores) {
            System.out.println(participante.getId());
            System.out.println("Numeros de Carton: " + participante);
        }

    }

    @Override
    public String toString() {
        return "Bingo [nombre=" + nombre + ", participantes=" + participantes + "]";
    }

}