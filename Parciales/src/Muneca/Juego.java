package Muneca;

import java.util.ArrayList;

public class Juego {

    private static final int RONDAS = 10;
    private static final int META = 150;
    private ArrayList<Jugador> ganadores;
    private ArrayList<Jugador> eliminados;
    private ArrayList<Jugador> jugadores;

    public Juego() {
        this.eliminados = new ArrayList<Jugador>();
        this.ganadores = new ArrayList<Jugador>();
        this.jugadores = new ArrayList<Jugador>();
    }

    private void crearJugadores(int cantJugadores) {

        for (int i = 0; i < cantJugadores; i++) {
            jugadores.add(new Jugador(i + 1));
        }
    }

    public void competir(int cantJugadores) {
        crearJugadores(cantJugadores);
        chequearJugadores(RONDAS);
    }

    private void chequearJugadores(int RONDAS) {
        for (int i = 0; i < RONDAS; i++) {
            luzverde(i);
            luzRoja();
            eliminarJugadores(i);
        }
    }

    private void eliminarJugadores(int ronda) {
        int i = 0;

        while (i < jugadores.size()) {
            Jugador jugadorActual = jugadores.get(i);
            jugadorActual.setRonda(ronda + 1);

            if (jugadorActual.isVivo() && jugadorActual.getmtsRecorridos() > META) {
                Jugador jugadorGanador = jugadores.remove(i);
                ganadores.add(jugadorGanador);
            } else if (!jugadorActual.isVivo()) {
                Jugador jugadorEliminado = jugadores.remove(i);
                eliminados.add(jugadorEliminado);
            } else {
                i++;
            }

        }
        if (ronda == 10) {
            jugadores.addAll(eliminados);
        }
    }

    private void luzverde(int ronda) {
        for (Jugador jugador : jugadores) {
            jugador.avanzar();
        }

        int i = 0;
        while (i < jugadores.size()) {
            Jugador jugadorActual = jugadores.get(i);
            jugadorActual.setRonda(ronda + 1);

            if (jugadorActual.isVivo() && jugadorActual.getmtsRecorridos() > META) {
                Jugador jugadorGanador = jugadores.remove(i);
                ganadores.add(jugadorGanador);
            } else {
                i++;
            }

        }
    }

    private void luzRoja() {
        for (Jugador jugador : jugadores) {
            if (!jugador.estaQuieto()) {
                jugador.setVivo(true);
            } else {
                jugador.setVivo(false);
            }
        }
    }

    public void mostrarResultados() {
        int contadorEliminados = 0;
        int contadorGanadores = 0;
        System.out.println("\n*** Ganadores ***");
        for (Jugador jugador : ganadores) {
            System.out.println(jugador);
            contadorGanadores++;
        }
        System.out.println("Ganadores: " + contadorGanadores);

        System.out.println("\n*** Eliminados ***");
        for (Jugador jugador : eliminados) {
            System.out.println(jugador);
            contadorEliminados++;
        }
        System.out.println("Eliminados: " + contadorEliminados);
    }

}
