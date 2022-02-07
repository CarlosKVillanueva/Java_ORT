package EquipoFutbol;

import java.util.ArrayList;

public class Partido {
    private String fecha;
    private ArrayList<Equipo> equipos;

    public Partido(String fecha) {
        this.fecha = fecha;
        equipos = new ArrayList<>();
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    private Equipo buscarEquipos(String nombre) {
        Equipo elementoBuscado = null;
        int i = 0, cantElementos = equipos.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (equipos.get(i).mismoEquipo(nombre)) {
                elementoBuscado = equipos.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    /* ----------------------- AGREGAR ---------------------- */

    public boolean agregarEquipo(String nombre) {
        boolean seAgrego = false;

        if (buscarEquipos(nombre) == null) {
            equipos.add(new Equipo(nombre));
            seAgrego = true;
        }

        return seAgrego;
    }

    /* ------------------- AGREGAR JUGADOR ------------------ */

    public boolean agregarJugadorEquipo(String nombre, int numero, String apellido, int goles) {
        boolean seAgrego = false;
        Equipo equipoEncontrado = buscarEquipos(nombre);

        if (equipoEncontrado != null) {
            seAgrego = equipoEncontrado.agregarJugador(numero, apellido, goles);
        }

        return seAgrego;
    }

    /* ----------------------- METODOS ---------------------- */

    public Resultado jugar(String nombreLocal, String nombreVisitante) {
        Resultado resultadoPartido = Resultado.EMPATE;

        if (nombreLocal != null && !nombreLocal.isEmpty()) {
            Equipo local = buscarEquipos(nombreLocal);
            if (nombreVisitante != null && !nombreVisitante.isEmpty()) {
                Equipo visitante = buscarEquipos(nombreVisitante);

                if (local.goles() > visitante.goles()) {
                    resultadoPartido = Resultado.LOCAL;
                } else if (local.goles() < visitante.goles()) {
                    resultadoPartido = Resultado.VISITANTE;
                } else {
                    resultadoPartido = Resultado.EMPATE;
                }
            }
        }
        return resultadoPartido;
    }

    public void mostrarGoles(String nombre, int numero) {
        Equipo equipoBuscado = buscarEquipos(nombre);
        if (nombre != null && !nombre.isEmpty()) {
            equipoBuscado.mostrarGoles(numero);
        } else {
            System.out.println("Error Equipo");
        }
    }

    @Override
    public String toString() {
        return "Partido [Fecha: " + fecha + "]";
    }

}
