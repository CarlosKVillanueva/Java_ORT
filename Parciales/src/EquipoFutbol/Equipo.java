package EquipoFutbol;

import java.util.ArrayList;

public class Equipo {
    private static final int JUGADORES_MAX = 14;

    private String nombre;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        jugadores = new ArrayList<>();
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    private Jugador buscarJugador(int numero) {
        Jugador elementoBuscado = null;
        int i = 0, cantElementos = jugadores.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (jugadores.get(i).mismoJugador(numero)) {
                elementoBuscado = jugadores.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    /* ----------------------- AGREGAR ---------------------- */

    public boolean agregarJugador(int numero, String apellido, int goles) {
        boolean seAgrego = false;

        if (buscarJugador(numero) == null && jugadores.size() <= JUGADORES_MAX) {
            jugadores.add(new Jugador(numero, apellido, goles));
            seAgrego = true;
        }

        return seAgrego;
    }

    /* ----------------------- METODOS ---------------------- */

    public boolean mismoEquipo(String nombre) {
        return this.nombre.equals(nombre);
    }

    public int goles() {
        int acumGoles = 0;
        for (Jugador jugador : jugadores) {
            acumGoles += jugador.getGoles();
        }
        return acumGoles;
    }

    public void mostrarGoles(int numero) {
        Jugador jugadorBuscado = buscarJugador(numero);
        System.out.println("*** Jugador ***");
        if (jugadorBuscado != null) {
            System.out.println(jugadorBuscado);
        } else {
            System.out.println("Jugador Inexistente");
        }
    }

    @Override
    public String toString() {
        return "Equipo [nombre=" + nombre + "]";
    }

}
