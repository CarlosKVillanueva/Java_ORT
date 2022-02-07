package Corredores;

import java.util.ArrayList;

public class Carrera {
    private String fecha;
    private String hora;
    private Dificultad dificultad;
    private ArrayList<Piloto> pilotos;
    /* --------------------- CONSTRUCTOR -------------------- */

    public Carrera(String fecha, String hora, Dificultad dificultad) {
        this.fecha = fecha;
        this.hora = hora;
        this.dificultad = dificultad;
        pilotos = new ArrayList<>();
    }
    /* ----------------------- GETTERS ---------------------- */

    /* ----------------------- SETTERS ---------------------- */

    /* ----------------------- METODOS ---------------------- */

    public void agregarPiloto(int cantidad) {
        for (int i = 1; i <= cantidad; i++) {
            pilotos.add(new Piloto(String.valueOf(i), String.valueOf("Piloto " + i)));
        }
    }

    public void agregarVueltas(int cantVueltas) {
        for (Piloto piloto : pilotos) {
            piloto.agregarVueltasPiloto(cantVueltas);
        }
    }

    private Piloto buscarPiloto(String dni) {
        Piloto elementoBuscado = null;
        int i = 0, cantElementos = pilotos.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (pilotos.get(i).mismoPiloto(dni)) {
                elementoBuscado = pilotos.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public boolean mismoFecha(String fecha) {
        return this.fecha.equals(fecha);
    }

    public double calcularPromedio(String dni) {
        Piloto piloto = buscarPiloto(dni);
        double promedio = 0;

        if (piloto != null)
            promedio = piloto.calcularPromedioVuelta();

        return promedio;
    }

    public boolean encontrePiloto(String dni) {
        return buscarPiloto(dni) != null;
    }

    public ArrayList<Piloto> buscarPilotosPorDebajoDe(double promedio) {
        ArrayList<Piloto> pilotosBajos = new ArrayList<>();

        for (Piloto piloto : pilotos) {
            if (piloto.tieneVueltasMinimas() && piloto.calcularPromedioVuelta() <= promedio) {
                pilotosBajos.add(piloto);
            }
        }

        return pilotosBajos;
    }

    public void mostrarMenorPromedio() {
        double acumPromedio = Double.MAX_VALUE;
        Piloto pilotoMenorPromedio = null;

        for (Piloto piloto : pilotos) {
            double promedioActual = piloto.calcularPromedioVuelta();
            if (promedioActual < acumPromedio) {
                acumPromedio = promedioActual;
                pilotoMenorPromedio = piloto;
            }
        }
        System.out.println(pilotoMenorPromedio);
    }

    public int cantPilotos() {
        return pilotos.size();
    }
    /* ---------------------- TO STRING --------------------- */

    @Override
    public String toString() {
        return "Carrera [dificultad=" + dificultad + ", fecha=" + fecha + ", hora=" + hora + "]";
    }

}
